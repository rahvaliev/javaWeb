package com.example.mobilelele.repository;

import com.example.mobilelele.model.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity,Long> {

}
