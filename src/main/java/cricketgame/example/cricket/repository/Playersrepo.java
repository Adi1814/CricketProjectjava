package cricketgame.example.cricket.repository;


import cricketgame.example.cricket.model.Players;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Playersrepo extends MongoRepository<Players,Long> {
}
