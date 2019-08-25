package com.projekat.poslovna.repository;

import com.projekat.poslovna.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by milan.miljus on 8/25/19 1:18 PM.
 */
@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
}
