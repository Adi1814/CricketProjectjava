package cricketgame.example.cricket.services;

import cricketgame.example.cricket.model.*;
import cricketgame.example.cricket.repository.MatchRepo;
import cricketgame.example.cricket.repository.TeamRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MatchSer {
    private final MatchRepo matchRepo;
    private final TeamRepo teamRepo;

    // RequiredArgsConstructors
//    public MatchSer(MatchRepo matchRepo, TeamRepo teamRepo){
//        this.matchRepo=matchRepo;
//        this.teamRepo=teamRepo;
//    }
    private List<Scoreboard> temp = new ArrayList<>();

    private Team t1, t2;
    private int r1;
    private int r2;
    private List<Scoreboard> temp1 = new ArrayList<>();
    private final TeamSer teamSer;

    public Match toss(Match match) {
        Random r = new Random();
        int toss = r.nextInt(2);
        if (toss == 1) {
            match.setBatting(match.getTeam1().getId());
        } else {
            match.setBatting(match.getTeam2().getId());
        }
        return (match);
    }

    public Match start(Long team1, Long team2) {
        t1 = teamRepo.getReferenceById(team1);
        t2 = teamRepo.getReferenceById(team2);
        Match match = new Match();
        match.setTeam1(t1);
        match.setTeam2(t2);
        match = toss(match);
        int i = 0;
        for (Players p : match.getTeam1().getPlayers()) {
            this.temp.add(new Scoreboard());
            this.temp.get(i).setPlayers(p);
            i++;
        }
        int y = 0;
        for (Players p : match.getTeam2().getPlayers()) {
            this.temp1.add(new Scoreboard());
            this.temp1.get(y).setPlayers(p);
            y++;
        }
        match = playInning1(match);
        match = playInning2(match);
        temp.addAll(temp1);
        match.setScoreboard(temp);
        //System.out.println(match.getInnings1());
        String res = evaluate();
        match.setResult(res);
        return matchRepo.save(match);

    }

    public String evaluate() {
        int diff = Math.abs(r2 - r1);
        if (r1 == r2) {
            return "It's a Draw!";
        } else if (r1 > r2) {
            return t1.getTeam() + " wins! by " + Integer.toString(diff);
        } else {
            return t2.getTeam() + " wins! " + Integer.toString(diff);
        }
    }

    public Match playInning1(Match match) {


        Innings in1 = new Innings();
        Pair<Integer, Integer> rw1 = inningssimulator(true);
        r1 = rw1.getFirst();
        int w1 = rw1.getSecond();
        in1.setWickets(w1);
        in1.setRuns(r1);
        in1.setInnings_no(1);
        match.setInnings1(in1);
        return match;
    }

    public Match playInning2(Match match) {

        Innings in2 = new Innings();
        Pair<Integer, Integer> rw2 = inningssimulator(false);
        r2 = rw2.getFirst();
        int w2 = rw2.getSecond();
        in2.setWickets(w2);
        in2.setRuns(r2);
        in2.setInnings_no(2);
        match.setInnings2(in2);
        System.out.println(match);
        return match;

    }
//    public Match scoreboard(Match match)
//    {
//        Scoreboard sc = new Scoreboard();
//
//
//
//    }

    private Pair<Integer, Integer> inningssimulator(boolean b) {
        int runs, tw = 0, sum = 0;
        int x = 0, k = 0;
        for (int i = 0; i < 10; i++) {
            int prevWicket = 0;
            int prevRuns = 0;

            for (int j = 0; j < 6; j++) {
                int min = 0;
                int max = 8;
                runs = (int) Math.floor(Math.random() * (max - min + 1) + min);
                // if runs value = 8 -> then the player is out
                if (runs == 8) {
                    int batsmanRun = sum - prevRuns;
                    prevRuns = sum;

                    if (b) {
                        this.temp.get(x).setRuns(batsmanRun);
                    } else {
                        this.temp1.get(x).setRuns(batsmanRun);
                    }
                    // player is out => increasing counter (player changed)
//                   x++;

                    if (tw >= 10) {
                        break;
                    } else {
                        tw += 1;
                        x++;
                    }

                } else {
                    sum += runs;
                }
            }
            int overWickets = tw - prevWicket;
            prevWicket = tw;
            if (b) {
                this.temp1.get(k).setWickets(overWickets);
            } else {
                this.temp.get(k).setWickets(overWickets);
            }
            k++;
        }
        Pair<Integer, Integer> p1 = Pair.of(sum, tw);
        return p1;
    }

}
