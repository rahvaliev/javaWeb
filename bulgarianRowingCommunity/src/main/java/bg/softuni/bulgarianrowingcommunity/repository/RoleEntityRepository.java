package bg.softuni.bulgarianrowingcommunity.repository;

import bg.softuni.bulgarianrowingcommunity.model.entity.RoleEntity;
import bg.softuni.bulgarianrowingcommunity.model.enums.RoleEnums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity,Long> {
    Optional<RoleEntity> findRoleEntitiesByRole(RoleEnums roleEnums);
}
