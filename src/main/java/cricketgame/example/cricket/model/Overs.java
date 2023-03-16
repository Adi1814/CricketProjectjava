package cricketgame.example.cricket.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Overs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    private long over_no;

    private long runs;
    private long wickets;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Balls> balls;


 //.  @ManyToOne(cascade = CascadeType.ALL)
//    private Innings Innings_id;

}
