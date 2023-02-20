package com.ex.examTR.repository;

import com.ex.examTR.model.entity.Condition;
import com.ex.examTR.model.entity.enums.ConditionNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConditionRepository extends JpaRepository<Condition,Long> {
    Optional<Condition> findByName(ConditionNameEnum name);
}
