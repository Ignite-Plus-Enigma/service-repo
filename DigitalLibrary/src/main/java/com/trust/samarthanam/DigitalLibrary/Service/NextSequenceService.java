package com.trust.samarthanam.DigitalLibrary.Service;

import com.trust.samarthanam.DigitalLibrary.Model.CustomSequences;
import com.trust.samarthanam.DigitalLibrary.dao.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class NextSequenceService {
    @Autowired private MongoOperations mongo;


    public int getNextSequence(String seqName)
    {
        CustomSequences counter= mongo.findAndModify(query(where("_id").is(seqName)),new Update().inc("seq",1),options().returnNew(true).upsert(true),CustomSequences.class);
        return !Objects.isNull(counter)? counter.getSeq():1;
    }

}
