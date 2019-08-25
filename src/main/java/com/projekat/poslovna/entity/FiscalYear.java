package com.projekat.poslovna.entity;

import com.projekat.poslovna.utils.Utils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by milan.miljus on 2019-04-27 19:25.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class FiscalYear extends BaseEntity {

    private int year;

    @Column(columnDefinition = "BIT default 0")
    private boolean concluded;

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

    public void conclude() {
        this.endedOn = Utils.getCurrentTimestamp();
        this.concluded = true;
    }

}
