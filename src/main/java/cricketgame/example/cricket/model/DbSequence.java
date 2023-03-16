package cricketgame.example.cricket.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DbSequence")
@Data
public class DbSequence {
    private String id;
    private int seq;


}
