package com.projekat.poslovna.repository;

import com.projekat.poslovna.entity.Document;
import com.projekat.poslovna.repository.base.CustomSoftDeleteRepo;
import org.springframework.stereotype.Repository;

/**
 * Created by milan.miljus on 2019-05-09 15:48.
 */
@Repository
public interface DocumentRepo extends CustomSoftDeleteRepo<Document> {
}
