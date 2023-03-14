package cricketgame.example.cricket.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;


@Entity
public class Players {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    String playerName;
    boolean batsman;
    boolean bowler;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(columnDefinition = "team_id")
   private Team team_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean isBatsman() {
        return batsman;
    }

    public void setBatsman(boolean batsman) {
        this.batsman = batsman;
    }

    public boolean isBowler() {
        return bowler;
    }

    public void setBowler(boolean bowler) {
        this.bowler = bowler;
    }
    @JsonBackReference
    public Team getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Team team_id) {
        this.team_id = team_id;
    }
}
