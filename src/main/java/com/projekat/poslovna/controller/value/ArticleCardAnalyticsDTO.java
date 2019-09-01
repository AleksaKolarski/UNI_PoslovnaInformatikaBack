package com.projekat.poslovna.controller.value;

import com.projekat.poslovna.entity.ArticleCardAnalytics;
import com.projekat.poslovna.entity.enums.DirectionEnum;
import com.projekat.poslovna.entity.enums.DocumentType;
import lombok.Getter;

/**
 * Created by milan.miljus on 9/1/19 3:51 PM.
 */
@Getter
public class ArticleCardAnalyticsDTO {

    private DocumentType type;
    private DirectionEnum direction;
    private int quantity;
    private long price;
    private long value;

    public ArticleCardAnalyticsDTO(ArticleCardAnalytics articleCardAnalytics) {
        this.type = articleCardAnalytics.getDocumentType();
        this.direction = articleCardAnalytics.getDirection();
        this.quantity = articleCardAnalytics.getQuantity();
        this.price = articleCardAnalytics.getPrice();
        this.value = articleCardAnalytics.getValue();
    }
}
