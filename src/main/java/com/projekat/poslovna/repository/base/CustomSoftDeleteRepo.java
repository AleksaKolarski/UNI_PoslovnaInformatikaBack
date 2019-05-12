package com.projekat.poslovna.repository.base;

import com.projekat.poslovna.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by milan.miljus on 2019-05-04 20:33.
 */
@NoRepositoryBean
public interface CustomSoftDeleteRepo<T extends BaseEntity> extends JpaRepository<T, UUID> {

    @Override
    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.deleted = true")
    List<T> findAll();

    @Override
    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.id = ?1 and e.deleted = true")
    Optional<T> findById(UUID id);

    @Override
    @Transactional
    default void delete(T entity) {
        deleteById(entity.getId());
    }

    @Override
    // TODO: 07 May 2019 00:00 milan.miljus uncomment for soft delete
    //@Query("update #{#entityName} e set e.deleted=false where e.id = ?1")
    @Transactional
    @Modifying
    void deleteById(UUID id);

}
