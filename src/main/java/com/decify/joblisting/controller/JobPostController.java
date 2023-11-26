package com.decify.joblisting.controller;

import com.decify.joblisting.model.JobPost;
import com.decify.joblisting.repo.JobPostRepository;
import com.decify.joblisting.repo.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class JobPostController {

    @Autowired
    JobPostRepository postRepository;

    @Autowired
    SearchRepository searchRepository;

    @ApiIgnore
    @RequestMapping(value = "/")
    private void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts/{searchKey}")
    private List<JobPost> searchJobPost(@PathVariable String searchKey) {
        return searchRepository.findBySearchKey(searchKey);
    }

    @GetMapping("/posts")
    private List<JobPost> getAllJobPost() {
        return postRepository.findAll();
    }

    @PostMapping("/post")
    private JobPost addPost(@RequestBody JobPost jobPost) {
        return postRepository.save(jobPost);
    }
}
