package com.projekat.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projekat.poslovna.entity.Document;

@Repository
public interface DocumentRepo extends JpaRepository<Document, Integer> {

}
