package com.example.mobilelele.repository;

import com.example.mobilelele.model.entity.UserRoleEntity;
import com.example.mobilelele.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {
  UserRoleEntity findByRole(UserRoleEnum role);
}
