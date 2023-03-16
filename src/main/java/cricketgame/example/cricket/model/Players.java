package cricketgame.example.cricket.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Players")
public class Players {
    @Id
    private long id;
    String playerName;
    boolean batsman;
    boolean bowler;



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



//    @Override
//    public String toString() {
//        return "Players{" +
//                "id=" + id +
//                ", playerName='" + playerName + '\'' +
//                ", batsman=" + batsman +
//                ", bowler=" + bowler +
//                ", team_id=" + team_id +
//                '}';
//    }
}
