package com.projekat.poslovna.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by milan.miljus on 2019-04-27 19:25.
 */
@Entity
@Data
@NoArgsConstructor
public class FiscalYear extends BaseEntity {

    private int year;

    private boolean concluded;

    @CreationTimestamp
    private Timestamp startedOn;

    private Timestamp endedOn;

    @OneToMany(mappedBy = "fiscalYear")
    private List<Document> documents;

    @OneToMany(mappedBy = "fiscalYear")
    private List<ArticleCard> articleCards;

    public FiscalYear(int year, boolean concluded) {
        this.year = year;
        this.concluded = concluded;
    }
}
