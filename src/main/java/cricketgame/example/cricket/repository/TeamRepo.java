package cricketgame.example.cricket.repository;

import cricketgame.example.cricket.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepo extends JpaRepository<Team, Long> {
   // List<Team> findAllById(int id);
    //List<Team> findAllById();
    // List<TeamRepo> AddTeams();
}
