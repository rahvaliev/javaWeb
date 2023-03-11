package bg.softuni.bulgarianrowingcommunity.model.entity;

import bg.softuni.bulgarianrowingcommunity.model.enums.ProgramTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "programs")
public class TrainingProgram extends BaseEntity{
    private String description;
    private ProgramTypeEnum programType;
    private Coach createdBy;

    public String getDescription() {
        return description;
    }

    public TrainingProgram setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProgramTypeEnum getProgramType() {
        return programType;
    }

    public TrainingProgram setProgramType(ProgramTypeEnum programType) {
        this.programType = programType;
        return this;
    }
    @ManyToOne
    public Coach getCreatedBy() {
        return createdBy;
    }

    public TrainingProgram setCreatedBy(Coach createdBy) {
        this.createdBy = createdBy;
        return this;
    }
}
