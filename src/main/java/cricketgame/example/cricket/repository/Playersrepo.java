package cricketgame.example.cricket.repository;


import cricketgame.example.cricket.model.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Playersrepo extends JpaRepository<Players,Long> {
}
