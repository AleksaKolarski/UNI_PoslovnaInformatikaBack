package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.ArticleCard;
import com.projekat.poslovna.entity.ArticleCardAnalytics;
import com.projekat.poslovna.entity.ArticleGroup;
import com.projekat.poslovna.entity.Warehouse;
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
        final Warehouse warehouse = warehouseService.getById(warehouseId);
        final List<ArticleCard> articleCards = warehouse.getArticleCards();
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
        return articleCardRepository.getByWarehouseIdAndArticleId(warehouseId, articleId).orElseThrow(() -> new NotFoundException("article card"));
    }

    @Transactional(rollbackFor = Throwable.class)
    public int save(ArticleCard articleCard) {
        return articleCardRepository.save(articleCard).getId();
    }

    @Transactional(rollbackFor = Throwable.class)
    public void updateArticleCard(int warehouseId, int articleId, int quantity, long price, DocumentType documentType) {
        final ArticleCard articleCard = getByWarehouseIdAndArticleId(warehouseId, articleId);

        switch (documentType) {
            case IMPORT:
                articleCard.setInPrice(articleCard.getInPrice() + quantity * price);
                articleCard.setInQuantity(articleCard.getInQuantity() + quantity);
                break;
            case EXPORT:
                if (articleCard.getQuantity() < quantity) {
                    throw new NotEnoughArticlesException(articleCard.getArticle().getName(), articleCard.getInQuantity());
                }
                articleCard.setOutPrice(articleCard.getOutPrice() - quantity * price);
                articleCard.setOutQuantity(articleCard.getOutQuantity() - quantity);
                break;
            default:
                throw new RuntimeException("");
        }

        createAnalyticsForTransaction(quantity, price, documentType, articleCard);
    }

    private void createAnalyticsForTransaction(int quantity, long price, DocumentType documentType, ArticleCard articleCard) {
        final ArticleCardAnalytics analytics = new ArticleCardAnalytics();
        analytics.setPrice(price);
        analytics.setQuantity(quantity);
        analytics.setDirection(documentType);
        analytics.setArticleCard(articleCard);
        articleCardAnalyticsRepository.save(analytics);
    }
}
