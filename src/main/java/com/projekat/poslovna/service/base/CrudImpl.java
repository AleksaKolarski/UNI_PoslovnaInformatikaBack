package com.projekat.poslovna.service.base;

import com.projekat.poslovna.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by milan.miljus on 2019-05-04 20:23.
 */
public abstract class CrudImpl<T extends BaseEntity> extends ReadImpl<T>{

    public CrudImpl(JpaRepository repo) {
        super(repo);
    }

    public T create(T entity) {
        return this.repo.save(entity);
    }

    public T update(T entity) {
        // TODO: 09 May 2019 15:55 milan.miljus validate if it exists
        return this.repo.save(entity);
    }

    // TODO: 09 May 2019 15:45 milan.miljus soft delete?
    public final void delete(T entity) {
        deleteById(entity.getId());
    }

    public void deleteById(UUID id) {
        this.repo.deleteById(id);
    }
}
