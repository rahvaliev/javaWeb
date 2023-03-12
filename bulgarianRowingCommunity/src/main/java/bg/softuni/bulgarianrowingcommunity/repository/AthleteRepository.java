package bg.softuni.bulgarianrowingcommunity.repository;

import bg.softuni.bulgarianrowingcommunity.model.entity.AthleteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends JpaRepository<AthleteEntity,Long> {
}
