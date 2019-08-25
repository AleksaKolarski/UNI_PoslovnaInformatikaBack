package com.projekat.poslovna.entity;

import com.projekat.poslovna.entity.enums.DirectionEnum;
import com.projekat.poslovna.entity.enums.DocumentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by milan.miljus on 2019-04-27 17:24.
 * Analatika magacinske kartice
 */
@Entity
@Getter
@Setter
public class ArticleCardAnalytics extends BaseEntity {

    private DirectionEnum direction;
    private long price;
    private int quantity;

    @ManyToOne
    private ArticleCard articleCard;

    public long getValue() {
        return price * quantity;
    }

    public void setDirection(DocumentType documentType) {
        this.direction = DirectionEnum.from(documentType);
    }

}
