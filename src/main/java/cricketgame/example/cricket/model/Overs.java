package cricketgame.example.cricket.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Overs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    private long over_no;

 //.  @ManyToOne(cascade = CascadeType.ALL)
//    private Innings Innings_id;

}
