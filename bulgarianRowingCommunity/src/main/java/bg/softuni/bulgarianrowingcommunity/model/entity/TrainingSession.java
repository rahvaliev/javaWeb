package bg.softuni.bulgarianrowingcommunity.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class TrainingSession extends BaseEntity {
    private Set<TrainingProgram> trainingProgramSet=new HashSet<>();
    private Athlete athlete;
    private Coach coach;
    @ManyToMany
    public Set<TrainingProgram> getTrainingProgramSet() {
        return trainingProgramSet;
    }

    public TrainingSession setTrainingProgramSet(Set<TrainingProgram> trainingProgramSet) {
        this.trainingProgramSet = trainingProgramSet;
        return this;
    }
    @ManyToOne
    public Athlete getAthlete() {
        return athlete;
    }

    public TrainingSession setAthlete(Athlete athlete) {
        this.athlete = athlete;
        return this;
    }
    @ManyToOne
    public Coach getCoach() {
        return coach;
    }

    public TrainingSession setCoach(Coach coach) {
        this.coach = coach;
        return this;
    }
}
