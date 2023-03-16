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
    private long id;
//    @ElementCollection
//    private ArrayList<ArrayList<Character>> scoreboard;


    int runs = 0;
    int wickets = 0;


    @OneToOne
    @JoinColumn
    private Players players;



}
