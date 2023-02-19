package com.example.examPrepCoco.service.impl;

import com.example.examPrepCoco.model.entities.Order;
import com.example.examPrepCoco.model.service.OrderServiceModel;
import com.example.examPrepCoco.model.view.OrderViewModel;
import com.example.examPrepCoco.repository.OrderRepository;
import com.example.examPrepCoco.sec.CurrentUser;
import com.example.examPrepCoco.service.CategoryService;
import com.example.examPrepCoco.service.OrderService;
import com.example.examPrepCoco.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;

    public OrderServiceImpl(OrderRepository orderRepository, CategoryService categoryService, ModelMapper modelMapper, CurrentUser currentUser, UserService userService) {
        this.orderRepository = orderRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {

        Order order = modelMapper.map(orderServiceModel, Order.class);
        order.setCategory(categoryService.findByCategoryEnum(orderServiceModel.getCategory()));
        order.setEmployee(userService.findById(currentUser.getId()));

        orderRepository.save(order);


    }



    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Integer total() {
        return 0;
    }

    @Override
    public List<OrderViewModel> findAllByPrice() {

       List<OrderViewModel> orders= orderRepository.findAll().stream()
               .map(order -> modelMapper.map(order, OrderViewModel.class)).toList();
       return orders;
    }
}
