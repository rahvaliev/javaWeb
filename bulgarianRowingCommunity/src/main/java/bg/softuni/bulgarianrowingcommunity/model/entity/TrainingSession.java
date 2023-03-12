package bg.softuni.bulgarianrowingcommunity.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class TrainingSession extends BaseEntity {
    private Set<TrainingProgram> trainingProgramSet=new HashSet<>();
    private AthleteEntity athleteEntity;
    private CoachEntity coach;
    @ManyToMany
    public Set<TrainingProgram> getTrainingProgramSet() {
        return trainingProgramSet;
    }

    public TrainingSession setTrainingProgramSet(Set<TrainingProgram> trainingProgramSet) {
        this.trainingProgramSet = trainingProgramSet;
        return this;
    }
    @ManyToOne
    public AthleteEntity getAthlete() {
        return athleteEntity;
    }

    public TrainingSession setAthlete(AthleteEntity athleteEntity) {
        this.athleteEntity = athleteEntity;
        return this;
    }
    @ManyToOne
    public CoachEntity getCoach() {
        return coach;
    }

    public TrainingSession setCoach(CoachEntity coach) {
        this.coach = coach;
        return this;
    }
}
