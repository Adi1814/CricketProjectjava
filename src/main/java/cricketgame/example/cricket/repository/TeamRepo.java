package cricketgame.example.cricket.repository;

import cricketgame.example.cricket.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepo extends MongoRepository<Team, Long> {

    Team getReferenceById(Long team1);
}
