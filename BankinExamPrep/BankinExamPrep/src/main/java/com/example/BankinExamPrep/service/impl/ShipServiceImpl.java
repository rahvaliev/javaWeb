package com.example.BankinExamPrep.service.impl;

import com.example.BankinExamPrep.model.entity.Ship;
import com.example.BankinExamPrep.model.service.ShipServiceModel;
import com.example.BankinExamPrep.repository.ShipRepository;
import com.example.BankinExamPrep.service.CategoryService;
import com.example.BankinExamPrep.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipRepository shipRepository;
    private final CategoryService categoryService;
    private final UserServiceImpl userService;
    private final ModelMapper modelMapper;

    public ShipServiceImpl(ShipRepository shipRepository, CategoryService categoryService,
                           UserServiceImpl userService, ModelMapper modelMapper) {
        this.shipRepository = shipRepository;
        this.categoryService = categoryService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(ShipServiceModel shipServiceModel) {
        Ship ship =modelMapper.map(shipServiceModel,Ship.class);
        ship.setCategory(categoryService.findByCategoryName(shipServiceModel.getCategory()));
        ship.setUser(userService.findById());

        shipRepository.save(ship);
    }

    @Override
    public void battle(Long attackerId, Long defenderId) {
        Ship attackerShip=shipRepository.findById(attackerId).orElse(null);
        Ship defenderShip=shipRepository.findById(defenderId).orElse(null);
        if(attackerShip==null || defenderShip==null){
            return;
        }
        long defenderHeathAfterAttack = defenderShip.getHealth() - attackerShip.getPower();
        if(defenderHeathAfterAttack<=0){
            shipRepository.deleteById(defenderId);
            return;
        }
        defenderShip.setHealth(defenderHeathAfterAttack);
        shipRepository.save(defenderShip);
    }
}
