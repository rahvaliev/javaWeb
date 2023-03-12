package bg.softuni.bulgarianrowingcommunity.repository;

import bg.softuni.bulgarianrowingcommunity.model.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity,Long> {
}
