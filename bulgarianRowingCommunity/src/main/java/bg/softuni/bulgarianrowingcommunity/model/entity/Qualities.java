package bg.softuni.bulgarianrowingcommunity.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "qualities")
public class Qualities extends BaseEntity{
    private Double height;
    private Double weight;
    private Double speed;
    private Integer age;
    private LocalDateTime createdOn;
    private AthleteEntity athleteEntity;
    private CoachEntity createdBy;

    public Double getHeight() {
        return height;
    }

    public Qualities setHeight(Double height) {
        this.height = height;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public Qualities setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Double getSpeed() {
        return speed;
    }

    public Qualities setSpeed(Double speed) {
        this.speed = speed;
        return this;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public Qualities setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Qualities setAge(Integer age) {
        this.age = age;
        return this;
    }
    @ManyToOne
    public AthleteEntity getAthlete() {
        return athleteEntity;
    }

    public Qualities setAthlete(AthleteEntity athleteEntity) {
        this.athleteEntity = athleteEntity;
        return this;
    }
    @ManyToOne
    public CoachEntity getCreatedBy() {
        return createdBy;
    }

    public Qualities setCreatedBy(CoachEntity createdBy) {
        this.createdBy = createdBy;
        return this;
    }
}
