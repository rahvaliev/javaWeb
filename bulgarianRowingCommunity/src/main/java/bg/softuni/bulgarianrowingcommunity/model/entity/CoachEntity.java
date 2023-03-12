package bg.softuni.bulgarianrowingcommunity.model.entity;

import bg.softuni.bulgarianrowingcommunity.model.enums.CoachLevelEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "coaches")
public class CoachEntity extends BaseUserEntity{
    private Double salary;
    private Double rating;
    private CoachLevelEnum coachLevel;
    private Team team;

    public Double getSalary() {
        return salary;
    }

    public CoachEntity setSalary(Double salary) {
        this.salary = salary;
        return this;
    }

    public Double getRating() {
        return rating;
    }

    public CoachEntity setRating(Double rating) {
        this.rating = rating;
        return this;
    }
    @Enumerated(EnumType.STRING)
    public CoachLevelEnum getCoachLevel() {
        return coachLevel;
    }

    public CoachEntity setCoachLevel(CoachLevelEnum coachLevel) {
        this.coachLevel = coachLevel;
        return this;
    }
    @ManyToOne

    public Team getTeam() {
        return team;
    }

    public CoachEntity setTeam(Team team) {
        this.team = team;
        return this;
    }
}
