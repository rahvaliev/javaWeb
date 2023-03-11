package bg.softuni.bulgarianrowingcommunity.model.entity;

import bg.softuni.bulgarianrowingcommunity.model.enums.CoachLevelEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "coaches")
public class Coach extends BaseUserEntity{
    private Double salary;
    private Double rating;
    private CoachLevelEnum coachLevel;

    public Double getSalary() {
        return salary;
    }

    public Coach setSalary(Double salary) {
        this.salary = salary;
        return this;
    }

    public Double getRating() {
        return rating;
    }

    public Coach setRating(Double rating) {
        this.rating = rating;
        return this;
    }
    @Enumerated(EnumType.STRING)
    public CoachLevelEnum getCoachLevel() {
        return coachLevel;
    }

    public Coach setCoachLevel(CoachLevelEnum coachLevel) {
        this.coachLevel = coachLevel;
        return this;
    }
}
