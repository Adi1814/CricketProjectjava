package cricketgame.example.cricket.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Scoreboard")
public class Scoreboard {
    @Id
    private long id;
    int runs = 0;
    int wickets = 0;
    private Players players;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Scoreboard{" +
                "id=" + id +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", players=" + players +
                '}';
    }

}
