package com.projekat.poslovna.repository;

import com.projekat.poslovna.entity.ArticleCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by milan.miljus on 8/24/19 5:36 PM.
 */
@Repository
public interface ArticleCardRepository extends JpaRepository<ArticleCard, Integer> {

    Optional<ArticleCard> getByWarehouseIdAndArticleId(int warehouseId, int articleId);

    Optional<ArticleCard> getByWarehouseIdAndArticleIdAndFiscalYearId(int warehouseId, int articleId, int fiscalYearId);

    List<ArticleCard> getByWarehouseIdAndFiscalYearId(int warehouseId, int fiscalYearId);
}




