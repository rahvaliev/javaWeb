package bg.softuni.bulgarianrowingcommunity.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity{
    private String name;
    private String city;
    private String emblemUrl;
    private List<AthleteEntity> athletes;
    private List<CoachEntity>coaches;
    private String description;

    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Team setCity(String city) {
        this.city = city;
        return this;
    }

    public String getEmblemUrl() {
        return emblemUrl;
    }

    public Team setEmblemUrl(String emblemUrl) {
        this.emblemUrl = emblemUrl;
        return this;
    }
    @OneToMany(mappedBy = "team")
    public List<AthleteEntity> getAthletes() {
        return athletes;
    }

    public Team setAthletes(List<AthleteEntity> athleteEntities) {
        this.athletes = athleteEntities;
        return this;
    }
    @OneToMany(mappedBy = "team")
    public List<CoachEntity> getCoaches() {
        return coaches;
    }

    public Team setCoaches(List<CoachEntity> coaches) {
        this.coaches = coaches;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Team setDescription(String description) {
        this.description = description;
        return this;
    }
}
