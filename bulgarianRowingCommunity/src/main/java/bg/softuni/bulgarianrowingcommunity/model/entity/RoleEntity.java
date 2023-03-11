package bg.softuni.bulgarianrowingcommunity.model.entity;

import bg.softuni.bulgarianrowingcommunity.model.enums.RoleEnums;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity{
    private RoleEnums role;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public RoleEnums getRole() {
        return role;
    }

    public RoleEntity setRole(RoleEnums role) {
        this.role = role;
        return this;
    }
}
