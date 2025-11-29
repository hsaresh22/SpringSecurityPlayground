package com.example.SpringSecurityPlayground.repo;

import com.example.SpringSecurityPlayground.model.Posts;
import lombok.NonNull;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepo extends JpaRepository<@NonNull Posts, @NonNull Integer> {

    @NullMarked
    List<Posts> findAll();
}
