package com.example.BankinExamPrep.repository;

import com.example.BankinExamPrep.model.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship,Long> {
    List<Ship> findByUser_Id(Long user_id);
    List<Ship> findByUser_IdNot(Long user_id);
    @Query("select s from Ship  s ORDER BY s.name,s.health desc ,s.power")
    List<Ship> findByOrderByNameHealthDescPower();
}
