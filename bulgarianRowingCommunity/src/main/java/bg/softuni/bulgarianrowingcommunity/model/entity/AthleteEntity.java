package bg.softuni.bulgarianrowingcommunity.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "athletes")
public class AthleteEntity extends BaseUserEntity{
    private Set<Qualities> qualities=new HashSet<>();
    private Double rating;
    private String level;
    private String motto;
    private Team team;

    @OneToMany(mappedBy = "athlete")
    public Set<Qualities> getQualities() {
        return qualities;
    }

    public AthleteEntity setQualities(Set<Qualities> qualities) {
        this.qualities = qualities;
        return this;
    }

    public Double getRating() {
        return rating;
    }

    public AthleteEntity setRating(Double rating) {
        this.rating = rating;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public AthleteEntity setLevel(String level) {
        this.level = level;
        return this;
    }

    public String getMotto() {
        return motto;
    }

    public AthleteEntity setMotto(String motto) {
        this.motto = motto;
        return this;
    }
    @ManyToOne
    public Team getTeam() {
        return team;
    }

    public AthleteEntity setTeam(Team team) {
        this.team = team;
        return this;
    }
}
