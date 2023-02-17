package com.example.AndrewsExamPrep.service.impl;

import com.example.AndrewsExamPrep.model.entity.Item;
import com.example.AndrewsExamPrep.model.service.ItemServiceModel;
import com.example.AndrewsExamPrep.model.view.ItemViewModel;
import com.example.AndrewsExamPrep.repository.ItemRepository;
import com.example.AndrewsExamPrep.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(ItemServiceModel itemServiceModel) {


        itemRepository.save(modelMapper.map(itemServiceModel, Item.class));

    }

    @Override
    public boolean findByName(String name) {

        if(itemRepository.findByName(name).orElse(null) ==null){
            return false;
        }
        return true;
    }

    @Override
    public List<ItemViewModel> findAll() {

        return itemRepository.findAll().stream()
                .map(item -> {
                  ItemViewModel itemViewModel=  modelMapper.map(item, ItemViewModel.class);
                  itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg",item.getGender().toUpperCase(),
                          item.getCategory().getName().name()));
                  return itemViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(Long id) {
        Item item=itemRepository.findById(id).orElse(null);
        ItemViewModel itemViewModel=  modelMapper.map(item, ItemViewModel.class);
        itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg",item.getGender().toUpperCase(),
                item.getCategory().getName().name()));
        return itemViewModel;


    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
