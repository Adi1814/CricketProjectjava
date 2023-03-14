package cricketgame.example.cricket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Generated;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.List;
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String team;

    private String Coach_name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "team_id")
    private List<Players> players;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCoach_name() {
        return Coach_name;
    }

    public void setCoach_name(String coach_name) {
        Coach_name = coach_name;
    }

    @JsonManagedReference
    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> player) {

        this.players = player;
        for(Players p : player)
        {
            p.setTeam_id(this);
        }
    }

//public int getPlayingTeamId() {
    //}
}
