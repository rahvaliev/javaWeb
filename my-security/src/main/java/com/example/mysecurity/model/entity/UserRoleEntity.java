package com.example.mysecurity.model.entity;

import com.example.mysecurity.model.enums.RoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity {
    private RoleEnum role;
    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    public RoleEnum getRole() {
        return role;
    }

    public UserRoleEntity setRole(RoleEnum role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "role=" + role +
                '}';
    }
}
