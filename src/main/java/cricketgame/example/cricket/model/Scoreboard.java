package cricketgame.example.cricket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Scoreboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
//    @ElementCollection
//    private ArrayList<ArrayList<Character>> scoreboard;


    int runs;
    int wickets;

    @OneToOne
   private Overs over;



    @OneToOne
    @JoinColumn
    private Players players;



}
