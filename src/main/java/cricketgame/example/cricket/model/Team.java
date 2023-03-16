package cricketgame.example.cricket.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "Team")
public class Team {

    @Transient
    public static final String SEQ_NAME="user_sequence";
    @Id

    private long id ;
    private String team;

    private String Coach_name;

    private List<Players> players;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCoach_name() {
        return Coach_name;
    }

    public void setCoach_name(String coach_name) {
        Coach_name = coach_name;
    }


    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> player) {

        this.players = player;

    }

//    @Override
//    public String toString() {
//        return "Team{" +
//                "id=" + id +
//                ", team='" + team + '\'' +
//                ", Coach_name='" + Coach_name + '\'' +
//                ", players=" + players +
//                '}';
//    }
    //public int getPlayingTeamId() {
    //}
}
