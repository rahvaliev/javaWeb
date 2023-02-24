package com.example.mysecurity.repository;

import com.example.mysecurity.model.entity.UserRoleEntity;
import com.example.mysecurity.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {
    Optional< UserRoleEntity >findUserRoleEntitiesByRole(RoleEnum role);
}
