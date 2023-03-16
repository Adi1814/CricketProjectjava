package cricketgame.example.cricket.repository;

import cricketgame.example.cricket.model.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepo extends MongoRepository<Match, Long> {
}
