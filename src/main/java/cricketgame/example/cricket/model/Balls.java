package cricketgame.example.cricket.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Balls")
public class Balls {
    @Id
    private long id;
    private long ballno;
    private long run;
    private int wicket;

    private Players bowler;

    private Players batsman;

    private Overs overs_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBallno() {
        return ballno;
    }

    public void setBallno(long ballno) {
        this.ballno = ballno;
    }

    public long getRun() {
        return run;
    }

    public void setRun(long run) {
        this.run = run;
    }

    public int getWicket() {
        return wicket;
    }

    public void setWicket(int wicket) {
        this.wicket = wicket;
    }

    public Players getBowler() {
        return bowler;
    }

    public void setBowler(Players bowler) {
        this.bowler = bowler;
    }

    public Players getBatsman() {
        return batsman;
    }

    public void setBatsman(Players batsman) {
        this.batsman = batsman;
    }

    public Overs getOvers_id() {
        return overs_id;
    }

    public void setOvers_id(Overs overs_id) {
        this.overs_id = overs_id;
    }
    @Override
    public String toString() {
        return "Balls{" +
                "id=" + id +
                ", ballno=" + ballno +
                ", run=" + run +
                ", wicket=" + wicket +
                ", bowler=" + bowler +
                ", batsman=" + batsman +
                ", overs_id=" + overs_id +
                '}';
    }
}
