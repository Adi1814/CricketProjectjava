package cricketgame.example.cricket.model;
import cricketgame.example.cricket.services.MatchSer;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Innings {

    @Id
    @GeneratedValue
    private long id;
    private long innings_no;
    private long runs;
    private long wickets;





}
