package cricketgame.example.cricket.services;

import cricketgame.example.cricket.model.Players;
import cricketgame.example.cricket.repository.MatchRepo;
import cricketgame.example.cricket.repository.Playersrepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerSer {
    public Playersrepo playersrepo;
    public MatchRepo matchRepo;
    public PlayerSer(Playersrepo playersrepo) {this.playersrepo = playersrepo;}

    public List<Players> findall() {return this.playersrepo.findAll();}

    public Players findPlayerById(long id) {return this.playersrepo.findById(id).orElse(null);}

    public Players Addplayers(Players players){return this.playersrepo.save(players);}
}