package cricketgame.example.cricket.controller;


import cricketgame.example.cricket.model.Team;
import cricketgame.example.cricket.repository.TeamRepo;
import cricketgame.example.cricket.services.TeamSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamCon {

    @Autowired
    TeamSer teamSer;
    @Autowired
    private TeamRepo teamRepo;

    @GetMapping
    public List<Team> findallteams(){
        return teamSer.findall();
    }
     @GetMapping("/{id}")
    public ResponseEntity<Team>
    findTeamById(@PathVariable(value="id") long id){
         Team team = teamSer.findTeamById(id);
         if(team!=null) {
             return ResponseEntity.ok().body(team);
         } else{
             return ResponseEntity.notFound().build();
         }
     }
     @PostMapping
     public Team saveTeam(@RequestBody Team team){
        System.out.println(team.getPlayers().get(0));
        return teamRepo.save(team);
     }
}
