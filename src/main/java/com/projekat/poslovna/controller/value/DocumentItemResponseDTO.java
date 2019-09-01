package com.projekat.poslovna.controller.value;

import com.projekat.poslovna.entity.DocumentItem;
import lombok.Getter;

@Getter
public class DocumentItemResponseDTO {

    private int quantity;

    private long price;

    private long value;

    private String articleName;

    public DocumentItemResponseDTO(DocumentItem documentItem) {
        this.quantity = documentItem.getQuantity();
        this.price = documentItem.getPrice();
        this.value = documentItem.getValue();
        this.articleName = documentItem.getArticle().getName();
    }

}
