package cricketgame.example.cricket.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Match {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL)
   private Team team1;
   @OneToOne(cascade = CascadeType.ALL)
   private Team team2;


    private Long batting;

    private String result;

    public String getResult() {
        return result;
    }



    public void setResult(String result) {
        this.result = result;
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<Scoreboard> scoreboard;

    @OneToOne(cascade = CascadeType.ALL)
    private Innings innings1;
    @OneToOne(cascade = CascadeType.ALL)
    private Innings innings2;

    public Innings getInnings1(Innings innings1) {
        return innings1;
    }

    public void setInnings1(Innings innings1) {
        this.innings1 = innings1;
    }

    public Innings getInnings2(Innings innings2) {
        return innings2;
    }

    public void setInnings2(Innings innings2) {
        this.innings2 = innings2;
    }

    public Match(){}

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", team1=" + team1 +
                ", team2=" + team2 +
                ", batting=" + batting +
                ", scoreboard_id=" + scoreboard +
                ", innings1=" + innings1 +
                ", innings2=" + innings2 +
                ", result=" + result +
                '}';
    }
}

