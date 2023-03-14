package cricketgame.example.cricket.services;

import cricketgame.example.cricket.model.Team;
import cricketgame.example.cricket.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamSer {

    public TeamRepo teamRepo;


    @Autowired
    public TeamSer(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }

    public List<Team> findall(){
        return this.teamRepo.findAll();
    }
    public Team findTeamById(long id){
        return this.teamRepo.findById(id).orElse(null);
    }

//    public Team AddTeams(Team team){
//        return this.teamRepo.save(team);
//    }
}
