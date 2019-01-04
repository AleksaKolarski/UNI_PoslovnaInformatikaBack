package com.projekat.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projekat.poslovna.entity.DocumentItem;

@Repository
public interface DocumentItemRepo extends JpaRepository<DocumentItem, Integer> {

}
