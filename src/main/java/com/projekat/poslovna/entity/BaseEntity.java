package com.projekat.poslovna.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by milan.miljus on 2019-04-27 16:01.
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @CreationTimestamp
    private Timestamp createdTime;

    @UpdateTimestamp
    private Timestamp updatedTime;

    private boolean deleted;

}
