package com.softuni.lastExamPrep.service;

import com.softuni.lastExamPrep.model.service.OrderServiceModel;
import com.softuni.lastExamPrep.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void save(OrderServiceModel orderServiceModel);

    Integer totalNeededTime();

    List<OrderViewModel> allOrders();

    void delete(Long id);
}
