package com.example.SpringSecurityPlayground.controller;

import com.example.SpringSecurityPlayground.model.Posts;
import com.example.SpringSecurityPlayground.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostsController {

    @Autowired
    PostsService postsService;

    @GetMapping("/posts")
    public List<Posts> getPosts() {
        return postsService.getPosts();
    }
}
