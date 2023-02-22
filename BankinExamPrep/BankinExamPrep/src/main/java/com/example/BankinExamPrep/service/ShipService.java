package com.example.BankinExamPrep.service;

import com.example.BankinExamPrep.model.service.ShipServiceModel;

public interface ShipService {
    void add(ShipServiceModel serviceModel);

    void battle(Long attackerId, Long defenderId);
}
