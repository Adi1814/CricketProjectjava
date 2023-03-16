package cricketgame.example.cricket.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
@Document(collection = "Overs")
public class Overs {

    @Id
    private long id;
    private long over_no;

    private long runs;
    private long wickets;

    private List<Balls> balls;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOver_no() {
        return over_no;
    }

    public void setOver_no(long over_no) {
        this.over_no = over_no;
    }

    public long getRuns() {
        return runs;
    }

    public void setRuns(long runs) {
        this.runs = runs;
    }

    public long getWickets() {
        return wickets;
    }

    public void setWickets(long wickets) {
        this.wickets = wickets;
    }

    public List<Balls> getBalls() {
        return balls;
    }

    public void setBalls(List<Balls> balls) {
        this.balls = balls;
    }

    @Override
    public String toString() {
        return "Overs{" +
                "id=" + id +
                ", over_no=" + over_no +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", balls=" + balls +
                '}';
    }
    //.  @ManyToOne(cascade = CascadeType.ALL)
//    private Innings Innings_id;

}
