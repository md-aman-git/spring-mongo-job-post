package com.decify.joblisting.controller;

import com.decify.joblisting.model.JobPost;
import com.decify.joblisting.repo.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class JobPostController {

    @Autowired
    JobPostRepository postRepository;

    @ApiIgnore
    @RequestMapping(value = "/")
    private void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
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
