package com.projekat.poslovna.entity;

import com.projekat.poslovna.entity.enums.DirectionEnum;
import com.projekat.poslovna.entity.enums.DocumentType;
import com.projekat.poslovna.utils.Utils;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Created by milan.miljus on 2019-04-27 17:24.
 * Analatika magacinske kartice
 */
@Entity
@Getter
@Setter
public class ArticleCardAnalytics extends BaseEntity {

    @NotNull
    private DocumentType documentType;

    @NotNull
    private DirectionEnum direction;

//    @Positive
    private Long price;

//    @Positive
    private int quantity;

    @NotNull
    @CreationTimestamp
    private Timestamp timestamp;

    @ManyToOne
    private ArticleCard articleCard;

    public Long getValue() {
        return price != null ? price * quantity : null;
    }

    @PrePersist
    private void setTimestamp() {
        this.timestamp = Utils.getCurrentTimestamp();
    }
}
