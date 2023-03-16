package cricketgame.example.cricket.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Balls {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long ballno;
    private long run;
    private int wicket;
    @OneToOne(cascade = CascadeType.ALL)
    private Players bowler;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "batsman_player_id")
    private Players batsman;

    @ManyToOne(cascade = CascadeType.ALL)
    private Overs overs_id;



}
