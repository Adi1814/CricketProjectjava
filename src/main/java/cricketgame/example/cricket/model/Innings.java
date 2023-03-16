package cricketgame.example.cricket.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "Innings")
public class Innings {

    @Id
    private long id;
    private long innings_no;
    private long runs;
    private long wickets;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getInnings_no() {
        return innings_no;
    }

    public void setInnings_no(long innings_no) {
        this.innings_no = innings_no;
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

    public List<Overs> getOvers() {
        return overs;
    }

    public void setOvers(List<Overs> overs) {
        this.overs = overs;
    }

    private List<Overs> overs = new ArrayList<>();

    public void addOvers (Overs over){
        overs.add(over);
    }


    @Override
    public String toString() {
        return "Innings{" +
                "id=" + id +
                ", innings_no=" + innings_no +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", overs=" + overs +
                '}';
    }
}
