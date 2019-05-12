package com.projekat.poslovna.entity;

import com.projekat.poslovna.entity.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by milan.miljus on 2019-04-27 17:24.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCardAnalytics extends BaseEntity {

    private DocumentType direction;
    private long price;
    private int quantity;

    @ManyToOne
    private ArticleCard articleCard;

    public long getValue() {
        return price * quantity;
    }

}
