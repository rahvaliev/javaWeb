package bg.softuni.bulgarianrowingcommunity.repository;

import bg.softuni.bulgarianrowingcommunity.model.entity.BaseUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<BaseUserEntity,Long> {
}
