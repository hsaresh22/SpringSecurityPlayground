package com.example.SpringSecurityPlayground.service;

import com.example.SpringSecurityPlayground.model.Posts;
import com.example.SpringSecurityPlayground.repo.PostsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {

    @Autowired
    PostsRepo postsRepo;

    public List<Posts> getPosts() {
        // Logic to retrieve posts from the database or any other source
        return postsRepo.findAll();
    }
}
