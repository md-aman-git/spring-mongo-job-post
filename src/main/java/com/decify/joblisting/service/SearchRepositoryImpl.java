package com.decify.joblisting.service;

import com.decify.joblisting.model.JobPost;
import com.decify.joblisting.repo.SearchRepository;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SearchRepositoryImpl implements SearchRepository {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<JobPost> findBySearchKey(String searchKey) {
        final List<JobPost> posts = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("decify-db");
        MongoCollection<Document> collection = database.getCollection("job-post");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "default")
                            .append("text", new Document("query", searchKey)
                                .append("path", Arrays.asList("techs", "profile", "desc")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 5L)));
        result.forEach(document -> posts.add(mongoConverter.read(JobPost.class, document)));
        return posts;
    }
}
