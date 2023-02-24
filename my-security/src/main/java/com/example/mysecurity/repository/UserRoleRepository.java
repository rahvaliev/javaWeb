package com.example.mysecurity.repository;

import com.example.mysecurity.model.entity.UserRoleEntity;
import com.example.mysecurity.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {
    UserRoleEntity findUserRoleEntitiesByRole(RoleEnum role);
}
