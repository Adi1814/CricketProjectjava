package cricketgame.example.cricket.controller;


import cricketgame.example.cricket.model.Match;
import cricketgame.example.cricket.repository.MatchRepo;
import cricketgame.example.cricket.services.MatchSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchCon {

    @Autowired
    MatchSer matchSer;

    @Autowired
    MatchRepo matchRepo;

    @PostMapping()
    public Match startmatch(@RequestBody Teams teams, @RequestParam String overs)
    {
        System.out.println("Teams => "+teams);
        int o = Integer.parseInt(overs);
        System.out.println("Teams1 =>"+teams.team1());
        return matchSer.start(teams.team1(),teams.team2(), o);
    }

    private static final class Teams {
        private final Long team1;
        private final Long team2;

        private Teams(Long team1, Long team2) {
            this.team1 = team1;
            this.team2 = team2;
        }

        public Long team1() {
            return team1;
        }

        public Long team2() {
            return team2;
        }


        @Override
        public String toString() {
            return "Teams[" +
                    "team1=" + team1 + ", " +
                    "team2=" + team2 + ']';
        }
    }
    @GetMapping()
    public List<Match> findMatches(){
        return matchSer.findMatches();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Match>
    findMatchById(@PathVariable(value="id")long id){
        Match match= matchSer.findMatchById(id);
        if(match!=null){
            return ResponseEntity.ok().body(match);
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}
