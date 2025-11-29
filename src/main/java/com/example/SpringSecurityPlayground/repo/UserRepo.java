package com.example.SpringSecurityPlayground.repo;

import com.example.SpringSecurityPlayground.model.Users;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<@NonNull Users, @NonNull Integer> {

    Users findByUsername(String username);
}
