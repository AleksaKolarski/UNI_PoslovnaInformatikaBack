package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.*;
import com.projekat.poslovna.entity.enums.DirectionEnum;
import com.projekat.poslovna.entity.enums.DocumentType;
import com.projekat.poslovna.repository.ArticleCardAnalyticsRepository;
import com.projekat.poslovna.repository.ArticleCardRepository;
import com.projekat.poslovna.service.exception.NotEnoughArticlesException;
import com.projekat.poslovna.service.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by milan.miljus on 8/24/19 5:38 PM.
 */
@Service
@AllArgsConstructor
public class ArticleCardService {

    private final WarehouseService warehouseService;
    private final ArticleGroupService articleGroupService;
    private final ArticleCardRepository articleCardRepository;
    private final ArticleCardAnalyticsRepository articleCardAnalyticsRepository;
    private final FiscalYearCurrent fiscalYearCurrent;

    @Transactional(rollbackFor = Throwable.class, readOnly = true)
    public List<ArticleCard> getAll() {
        return articleCardRepository.findAll();
    }

    @Transactional(rollbackFor = Throwable.class, readOnly = true)
    public List<ArticleCard> getArticleCardsByArticleGroup(int warehouseId, int articleGroupId) {
        final List<ArticleCard> articleCardsForWarehouse = getArticleCardsForWarehouse(warehouseId);
        final ArticleGroup articleGroup = articleGroupService.getById(articleGroupId);
        return articleCardsForWarehouse.stream()
                .filter(articleCard -> articleCard.getArticleGroup().equals(articleGroup))
                .collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Throwable.class, readOnly = true)
    public List<ArticleCard> getArticleCardsForWarehouse(int warehouseId) {
        final List<ArticleCard> articleCards =
                articleCardRepository.getByWarehouseIdAndFiscalYearId(warehouseId, fiscalYearCurrent.get().getId());
        return articleCards;
    }

    @Transactional(rollbackFor = Throwable.class)
    public ArticleCard getArticleCard(int warehouseId, int articleId, int fiscalYearId) {
        return articleCardRepository.getByWarehouseIdAndArticleIdAndFiscalYearId(warehouseId, articleId, fiscalYearId).get();
    }

    @Transactional(rollbackFor = Throwable.class, readOnly = true)
    public ArticleCard getById(int id) {
        return articleCardRepository.findById(id).orElseThrow(() -> new NotFoundException("article card"));
    }

    @Transactional(rollbackFor = Throwable.class, readOnly = true)
    public ArticleCard getByWarehouseIdAndArticleId(int warehouseId, int articleId) {
        final int fiscalYearId = fiscalYearCurrent.get().getId();
        return articleCardRepository
                .getByWarehouseIdAndArticleIdAndFiscalYearId(warehouseId, articleId, fiscalYearId)
                .orElseThrow(() -> new NotFoundException("article card"));
    }

    @Transactional(rollbackFor = Throwable.class)
    public int save(ArticleCard articleCard) {
        return articleCardRepository.save(articleCard).getId();
    }

    @Transactional(rollbackFor = Throwable.class)
    public void updateArticleCard(int warehouseId, int articleId, int quantity, Long price, DocumentType documentType) {
        final ArticleCard articleCard = getByWarehouseIdAndArticleId(warehouseId, articleId);

        DirectionEnum direction = null;
        switch (documentType) {
            case IMPORT:
                articleCard.setInValue(articleCard.getInValue() + quantity * price);
                articleCard.setInQuantity(articleCard.getInQuantity() + quantity);
                direction = DirectionEnum.IN;
                break;
            case EXPORT:
                if (articleCard.getQuantity() < quantity) {
                    throw new NotEnoughArticlesException(articleCard);
                }
                articleCard.setOutValue(articleCard.getOutValue() + quantity * price);
                articleCard.setOutQuantity(articleCard.getOutQuantity() + quantity);
                direction = DirectionEnum.OUT;
                break;
            case IN_HOUSE:
            default:
                throw new RuntimeException("");
        }

        createAnalyticsForTransaction(quantity, price, documentType, direction, articleCard);
    }

    @Transactional(rollbackFor = Throwable.class)
    public void updateArticleCardInHouse(int sourceWarehouseId, int targetWarehouseId, int articleId, int quantity) {
        final ArticleCard sourceArticleCard = getByWarehouseIdAndArticleId(sourceWarehouseId, articleId);
        final ArticleCard targetArticleCard = getByWarehouseIdAndArticleId(targetWarehouseId, articleId);

        if (sourceArticleCard.getQuantity() < quantity) {
            throw new NotEnoughArticlesException(sourceArticleCard);
        }

        sourceArticleCard.setOutQuantity(sourceArticleCard.getOutQuantity() + quantity);
        targetArticleCard.setInQuantity(targetArticleCard.getInQuantity() + quantity);

        createAnalyticsForTransaction(quantity, null, DocumentType.IN_HOUSE, DirectionEnum.OUT, sourceArticleCard);
        createAnalyticsForTransaction(quantity, null, DocumentType.IN_HOUSE, DirectionEnum.IN, targetArticleCard);
    }

    private void createAnalyticsForTransaction(int quantity, Long price, DocumentType documentType, DirectionEnum direction, ArticleCard articleCard) {
        final ArticleCardAnalytics analytics = new ArticleCardAnalytics();
        analytics.setPrice(price);
        analytics.setQuantity(quantity);
        analytics.setDirection(direction);
        analytics.setDocumentType(documentType);
        analytics.setArticleCard(articleCard);
        articleCardAnalyticsRepository.save(analytics);
    }
}
