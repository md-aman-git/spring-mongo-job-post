package com.decify.joblisting.repo;

import com.decify.joblisting.model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobPostRepository extends MongoRepository<JobPost, String> {
}
