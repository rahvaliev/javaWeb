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
    private Athlete athlete;
    private Coach createdBy;

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
    public Athlete getAthlete() {
        return athlete;
    }

    public Qualities setAthlete(Athlete athlete) {
        this.athlete = athlete;
        return this;
    }
    @ManyToOne
    public Coach getCreatedBy() {
        return createdBy;
    }

    public Qualities setCreatedBy(Coach createdBy) {
        this.createdBy = createdBy;
        return this;
    }
}
