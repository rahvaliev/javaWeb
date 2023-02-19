package com.example.examPrepCoco.service;

import com.example.examPrepCoco.model.entities.Order;
import com.example.examPrepCoco.model.service.OrderServiceModel;
import com.example.examPrepCoco.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);



    void delete(Long id);

    Integer total();

    List<OrderViewModel> findAllByPrice();
}
