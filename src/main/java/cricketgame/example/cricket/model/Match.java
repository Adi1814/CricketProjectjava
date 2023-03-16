package cricketgame.example.cricket.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "Match")
public class Match {
    @Id
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


   private Team team1;

   private Team team2;


    private Long batting;

    private String result;

    public String getResult() {
        return result;
    }



    public void setResult(String result) {
        this.result = result;
    }


    private List<Scoreboard> scoreboard;


    private Innings innings1;

    private Innings innings2;

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Long getBatting() {
        return batting;
    }

    public void setBatting(Long batting) {
        this.batting = batting;
    }

    public List<Scoreboard> getScoreboard() {
        return scoreboard;
    }

    public void setScoreboard(List<Scoreboard> scoreboard) {
        this.scoreboard = scoreboard;
    }

    public Innings getInnings1() {
        return innings1;
    }

    public void setInnings1(Innings innings1) {
        this.innings1 = innings1;
    }

    public Innings getInnings2() {
        return innings2;
    }

    public void setInnings2(Innings innings2) {
        this.innings2 = innings2;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", team1=" + team1 +
                ", team2=" + team2 +
                ", batting=" + batting +
                ", result='" + result + '\'' +
                ", scoreboard=" + scoreboard +
                ", innings1=" + innings1 +
                ", innings2=" + innings2 +
                '}';
    }
}

