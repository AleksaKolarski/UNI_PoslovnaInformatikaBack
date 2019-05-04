package com.projekat.poslovna.repository;

import com.projekat.poslovna.entity.ArticleCard;
import com.projekat.poslovna.repository.base.CustomSoftDeleteRepo;
import org.springframework.stereotype.Repository;

/**
 * Created by milan.miljus on 2019-05-04 20:07.
 */
@Repository
public interface ArticleCardRepo extends CustomSoftDeleteRepo<ArticleCard> {
}
