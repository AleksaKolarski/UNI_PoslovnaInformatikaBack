package com.projekat.poslovna.service.base;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by milan.miljus on 2019-05-04 20:20.
 */
public abstract class ReadImpl<T> implements IRead<T> {

    protected final JpaRepository<T, UUID> repo;

    public ReadImpl(JpaRepository repo) {
        this.repo = repo;
    }

    @Override
    public Optional<T> findById(UUID id) {
        return repo.findById(id);
    }

    @Override
    public List<T> findAll() {
        return repo.findAll();
    }
}
