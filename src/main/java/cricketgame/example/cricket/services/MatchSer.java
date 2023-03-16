package cricketgame.example.cricket.services;
import cricketgame.example.cricket.model.*;
import cricketgame.example.cricket.repository.MatchRepo;
import cricketgame.example.cricket.repository.TeamRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MatchSer {
    private final MatchRepo matchRepo;
    private final TeamRepo teamRepo;
    private final List<Scoreboard> temp = new ArrayList<>();
    private final List<Scoreboard> temp1 = new ArrayList<>();
    private final TeamSer teamSer;
    private Team t1, t2;
    private long r1;
    private long r2;

    private int ov = 0;//to set overs
    public List<Match> findMatches() {
        return this.matchRepo.findAll();
    }

    public Match findMatchById(long id) {
        return this.matchRepo.findById(id).orElse(null);
    }

    public Match toss(Match match) {
        Random r = new Random();
        int toss = r.nextInt(2);
        if (toss == 1) {
            System.out.println(match.getTeam1());
//            match.setBatting(match.getTeam1().getId());
//            System.out.println(t1);
//            match.setBatting(t1.getId());
        } else {
            match.setBatting(match.getTeam2().getId());
//            System.out.println(match.getTeam1());
//            System.out.println(t2);
//            match.setBatting(t2.getId());
        }
        return (match);
    }

    public Match start(Long team1, Long team2, int o) {
        ov = o;
        t1 = teamRepo.getReferenceById(team1);
        t2 = teamRepo.getReferenceById(team2);
        System.out.println("Team1 =>"+t1);
        System.out.println(("Team2 =>"+t2));
//        return null;
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
//        return null;
        temp.addAll(temp1);
        match.setScoreboard(temp);
        //System.out.println(match.getInnings1());
        String res = evaluate();
        match.setResult(res);
        return matchRepo.save(match);
//         return null;
    }

    public String evaluate() {
        long diff = Math.abs(r1 - r2);
        if (r1 == r2) {
            return "It's a Draw!";
        } else if (r1 > r2) {
            return t1.getTeam() + " wins! by " + diff;
        } else {
            return t2.getTeam() + " wins! " + diff;
        }
    }

    public Match playInning1(Match match) {


        Innings in1 = new Innings();
        in1 = inningsSimulator(true, in1);
        r1 = in1.getRuns();
        match.setInnings1(in1);
        return match;
    }

    public Match playInning2(Match match) {

        Innings in2 = new Innings();
        in2 = inningsSimulator(false, in2);
        r2 = in2.getRuns();
        match.setInnings2(in2);
        return match;

    }

    private Innings inningsSimulator(boolean isInnings1, Innings innings) {
        if (isInnings1) {
            innings.setInnings_no(1);
        } else {
            innings.setInnings_no(2);
        }
        List<Overs> o = new ArrayList<Overs>();
        int runs, tw = 0, sum = 0;
        int x = 1, k = 0;
        int prevRuns = 0;
        int prevWicket = 0;
        for (int i = 0; i < ov; i++)
        {
            Overs overs = new Overs();
            overs.setOver_no(i);
            List<Balls> bs = new ArrayList<Balls>();
            int runsperover=0;
            int wicketsperover=0;
            for (int j = 0; j < 6; j++)
            {

                Balls balls = new Balls();
                balls.setBallno(j);
                int min = 0;
                int max = 8;
                runs = (int) Math.floor(Math.random() * (max - min + 1) + min);
                runsperover+=runs;
                // if runs value = 8 -> then the player is out
                if (runs == 8) {
                    int batsmanRun = sum - prevRuns;
                    prevRuns = sum;
                    if (isInnings1) {
                        this.temp.get(tw).setRuns(batsmanRun);
                    } else {
                        this.temp1.get(tw).setRuns(batsmanRun);
                    }
                    // player is out => increasing counter (player changed)
//                   x++;
                    if (tw >= 10) {
                        break;
                    } else {
                        tw += 1;
                        wicketsperover+=tw;
//                        x++;
                    }
//                    x++;
                } else {
                    sum += runs;
                }
                bs.add(balls);
            }
            int overWickets = tw - prevWicket;
            int overRuns = runsperover;
            prevWicket = tw;
            if (isInnings1) {
                int wkts = this.temp1.get(k).getWickets() + overWickets;

                this.temp1.get(k).setWickets(wkts);
            } else {
                int wkts = this.temp.get(k).getWickets() + overWickets;

                this.temp.get(k).setWickets(wkts);

            }
            k = (k + 1) % 10;
            overs.setBalls(bs);
            overs.setRuns(overRuns);
            overs.setWickets(wicketsperover);
            o.add(overs);
            if (tw >= 10) {
                break;
            }
        }
        innings.setWickets(tw);
        innings.setOvers(o);
        innings.setRuns(sum);
        return innings;
    }
}
