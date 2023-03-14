package cricketgame.example.cricket.repository;

import cricketgame.example.cricket.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepo extends JpaRepository<Match, Integer> {
}
