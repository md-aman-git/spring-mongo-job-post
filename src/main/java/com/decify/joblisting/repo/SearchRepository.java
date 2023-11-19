package com.decify.joblisting.repo;

import com.decify.joblisting.model.JobPost;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository {
    List<JobPost> findBySearchKey(String searchKey);
}
