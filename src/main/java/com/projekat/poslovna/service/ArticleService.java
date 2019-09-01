package com.projekat.poslovna.service;

import com.projekat.poslovna.controller.value.ArticleCreateDTO;
import com.projekat.poslovna.entity.Article;
import com.projekat.poslovna.entity.ArticleCard;
import com.projekat.poslovna.entity.ArticleGroup;
import com.projekat.poslovna.repository.ArticleRepository;
import com.projekat.poslovna.service.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by milan.miljus on 8/24/19 2:12 PM.
 */
@Service
@AllArgsConstructor
public class ArticleService {

    private final ArticleGroupService articleGroupService;
    private final ArticleRepository articleRepository;
    private final WarehouseService warehouseService;
    private final FiscalYearCurrent fiscalYearCurrent;
    private final ArticleCardService articleCardService;


    public Article findById(int id) {
        return articleRepository.findById(id).orElseThrow(() -> new NotFoundException("article"));
    }

    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @SuppressWarnings("DuplicatedCode")
    @Transactional(rollbackFor = Throwable.class)
    public int createArticle(final ArticleCreateDTO articleDTO) {
        final ArticleGroup articleGroup = articleGroupService.getById(articleDTO.getArticleGroupId());
        final Article article = new Article(articleDTO.getName(), articleDTO.getUnit(), articleGroup);

        warehouseService.getAll().forEach(warehouse -> {
            final ArticleCard newArticleCard = new ArticleCard();
            newArticleCard.setArticle(article);
            newArticleCard.setFiscalYear(fiscalYearCurrent.get());
            newArticleCard.setStartStateValue(0);
            newArticleCard.setStartStateQuantity(0);
            newArticleCard.setWarehouse(warehouse);
            articleCardService.save(newArticleCard);
        });

        return article.getId();
    }

}
