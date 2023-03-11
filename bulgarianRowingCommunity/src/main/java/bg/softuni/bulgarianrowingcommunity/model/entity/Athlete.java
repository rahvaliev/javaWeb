package bg.softuni.bulgarianrowingcommunity.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "athletes")
public class Athlete extends BaseUserEntity{
    private Set<Qualities> qualities=new HashSet<>();
    private Double rating;
    private String level;

    @OneToMany(mappedBy = "athlete")
    public Set<Qualities> getQualities() {
        return qualities;
    }

    public Athlete setQualities(Set<Qualities> qualities) {
        this.qualities = qualities;
        return this;
    }

    public Double getRating() {
        return rating;
    }

    public Athlete setRating(Double rating) {
        this.rating = rating;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public Athlete setLevel(String level) {
        this.level = level;
        return this;
    }
}
