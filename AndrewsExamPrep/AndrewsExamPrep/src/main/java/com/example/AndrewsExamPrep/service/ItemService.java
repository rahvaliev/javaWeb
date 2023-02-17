package com.example.AndrewsExamPrep.service;

import com.example.AndrewsExamPrep.model.binding.ItemAddBindingModel;
import com.example.AndrewsExamPrep.model.entity.Item;
import com.example.AndrewsExamPrep.model.service.ItemServiceModel;
import com.example.AndrewsExamPrep.model.view.ItemViewModel;

import java.util.List;

public interface ItemService {
    void save(ItemServiceModel itemServiceModel);

    boolean findByName(String name);

    List<ItemViewModel> findAll();

    ItemViewModel findById(Long id);

    void delete(Long id);
}
