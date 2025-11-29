package com.example.SpringSecurityPlayground.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Posts {
    @Getter
    @Setter
    @Id
    private int user_id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String content;

    @Override
    public String toString() {
        return "Posts{" +
                "user_id=" + user_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
