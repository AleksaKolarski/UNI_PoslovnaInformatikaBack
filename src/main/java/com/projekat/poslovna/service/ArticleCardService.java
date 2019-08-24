package com.projekat.poslovna.service;

import com.projekat.poslovna.entity.ArticleCard;
import com.projekat.poslovna.entity.ArticleGroup;
import com.projekat.poslovna.entity.Warehouse;
import com.projekat.poslovna.repository.ArticleCardRepository;
import com.projekat.poslovna.service.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by milan.miljus on 8/24/19 5:38 PM.
 */
@Service
@AllArgsConstructor
public class ArticleCardService {

    private final WarehouseService warehouseService;
    private final ArticleGroupService articleGroupService;
    private final ArticleCardRepository articleCardRepository;

    public List<ArticleCard> getArticleCardsByArticleGroup(int warehouseId, int articleGroupId) {
        final List<ArticleCard> articleCardsForWarehouse = getArticleCardsForWarehouse(warehouseId);
        final ArticleGroup articleGroup = articleGroupService.getById(articleGroupId);
        return articleCardsForWarehouse.stream()
                .filter(articleCard -> articleCard.getArticleGroup().equals(articleGroup))
                .collect(Collectors.toList());
    }

    public List<ArticleCard> getArticleCardsForWarehouse(int warehouseId) {
        final Warehouse warehouse = warehouseService.getById(warehouseId);
        final List<ArticleCard> articleCards = warehouse.getArticleCards();
        return articleCards;
    }

    public ArticleCard getById(int id) {
        return articleCardRepository.findById(id).orElseThrow(() -> new NotFoundException("article card"));
    }
}
