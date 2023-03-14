package cricketgame.example.cricket.controller;

import cricketgame.example.cricket.model.Players;
import cricketgame.example.cricket.repository.Playersrepo;
import cricketgame.example.cricket.services.PlayerSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayersCont {
    @Autowired
    private PlayerSer playerSer;

    @Autowired
    private Playersrepo playersrepo;

  @GetMapping()
    public List<Players> findall(){
      return playerSer.findall();
  }
  @GetMapping("/{id}")
  public ResponseEntity<Players>
  findPlayerById(@PathVariable(value="id")long id){
      Players players= playerSer.findPlayerById(id);
      if(players!=null){
          return ResponseEntity.ok().body(players);
      } else{
          return ResponseEntity.notFound().build();
      }
    }
}
