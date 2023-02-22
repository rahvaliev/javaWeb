package com.softuni.lastExamPrep.service.impl;

import com.softuni.lastExamPrep.model.entity.Order;
import com.softuni.lastExamPrep.model.service.OrderServiceModel;
import com.softuni.lastExamPrep.model.view.OrderViewModel;
import com.softuni.lastExamPrep.repository.OrderRepository;
import com.softuni.lastExamPrep.service.CategoryService;
import com.softuni.lastExamPrep.service.OrderService;
import com.softuni.lastExamPrep.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, CategoryService categoryService, UserService userService, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.categoryService = categoryService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(OrderServiceModel orderServiceModel) {
        Order order=modelMapper.map(orderServiceModel,Order.class);
        order.setCategory(categoryService.findByCategoryName(orderServiceModel.getCategory()));
        order.setEmployee(userService.findById());
        orderRepository.save(order);
    }

    @Override
    public Integer totalNeededTime() {
        return orderRepository.findTotalNeededTime();
    }

    @Override
    public List<OrderViewModel> allOrders() {

        return orderRepository.findAllByPriceDesc().stream()
                .map(order -> modelMapper.map(order,OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
      Order order=orderRepository.findById(id).orElse(null);
      if(userService.findById().getId()!=order.getEmployee().getId()){
          return;
      }
        orderRepository.deleteById(id);
    }
}
