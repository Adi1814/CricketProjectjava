package cricketgame.example.cricket.controller;


import cricketgame.example.cricket.model.Match;
import cricketgame.example.cricket.model.Team;
import cricketgame.example.cricket.repository.MatchRepo;
import cricketgame.example.cricket.services.MatchSer;
import cricketgame.example.cricket.services.TeamSer;
import cricketgame.example.cricket.services.MatchSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/match")
public class MatchCon {

    @Autowired
    MatchSer matchSer;

    @Autowired
    MatchRepo matchRepo;

    @PostMapping()
    public Match startmatch(@RequestBody Teams teams)
    {

        return matchSer.start(teams.team1(),teams.team2());
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

}
