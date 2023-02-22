package com.softuni.lastExamPrep.repository;

import com.softuni.lastExamPrep.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("select sum (o.category.neededTime) from Order o ")
    Integer findTotalNeededTime();
    @Query("select o from Order o order by o.price desc ")
    List<Order>findAllByPriceDesc();

}
