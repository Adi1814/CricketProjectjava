package cricketgame.example.cricket.services;

import cricketgame.example.cricket.model.DbSequence;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;


import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceGeneratorService {
    @Autowired
    private MongoOperations mongoOperations;

    public int getSequenceNumber(String SequenceName)
    {
        Query query = new Query(Criteria.where("id").is(SequenceName));
        Update update= new Update().inc("seq", 1);
        DbSequence counter = mongoOperations.findAndModify(query,update, options().returnNew(true).upsert(true),DbSequence.class);
        System.out.println(counter);
        return !Objects.isNull(counter) ? counter.getSeq():1;
    }

}
