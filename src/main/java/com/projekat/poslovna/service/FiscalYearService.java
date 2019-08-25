package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.Article;
import com.projekat.poslovna.entity.ArticleCard;
import com.projekat.poslovna.entity.FiscalYear;
import com.projekat.poslovna.entity.Warehouse;
import com.projekat.poslovna.repository.FiscalYearRepository;
import com.projekat.poslovna.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Created by milan.miljus on 8/25/19 1:06 PM.
 */
@Service
@RequiredArgsConstructor
public class FiscalYearService {

    private FiscalYear currentFiscalYear;

    private final ArticleService articleService;
    private final ArticleCardService articleCardService;
    private final WarehouseService warehouseService;
    private final FiscalYearRepository fiscalYearRepository;

    @PostConstruct
    private void setCurrentFiscalYear() {
        this.currentFiscalYear = fiscalYearRepository.getByConcludedFalse();
    }

    public FiscalYear getCurrent() {
        return this.currentFiscalYear;
    }

    @Transactional(rollbackFor = Throwable.class)
    public void conclude() {
        final FiscalYear oldFiscalYear = this.currentFiscalYear;
        this.currentFiscalYear.conclude();
        this.currentFiscalYear = createNewFiscalYear();

        warehouseService.getAll().forEach(warehouse ->
            articleService.getAll().forEach(article ->
                createNewArticleCard(oldFiscalYear, warehouse, article)
            )
        );
    }

    private void createNewArticleCard(FiscalYear oldFiscalYear, Warehouse warehouse, Article article) {
        final ArticleCard oldArticleCard = articleCardService.getArticleCard(
                warehouse.getId(),
                article.getId(),
                oldFiscalYear.getId()
        );

        final ArticleCard newArticleCard = new ArticleCard();
        newArticleCard.setArticle(article);
        newArticleCard.setFiscalYear(this.currentFiscalYear);
        newArticleCard.setStartStatePrice(oldArticleCard.getPrice());
        newArticleCard.setStartStateQuantity(oldArticleCard.getQuantity());
        newArticleCard.setWarehouse(warehouse);
        articleCardService.save(newArticleCard);
    }


    private FiscalYear createNewFiscalYear() {
        final FiscalYear newFiscalYear = new FiscalYear();
        newFiscalYear.setStartedOn(Utils.getCurrentTimestamp());
        newFiscalYear.setYear(currentFiscalYear.getYear() + 1);
        fiscalYearRepository.save(newFiscalYear);
        return newFiscalYear;
    }

}
