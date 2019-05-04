package com.projekat.poslovna.service.base;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by milan.miljus on 2019-05-04 20:23.
 */
public abstract class CrudImpl<T> extends ReadImpl<T> implements ICrud<T> {

    public CrudImpl(JpaRepository repo) {
        super(repo);
    }

    @Override
    public T save(T entity) {
        return null;
    }

    @Override
    public void delete(T entity) {

    }
}
