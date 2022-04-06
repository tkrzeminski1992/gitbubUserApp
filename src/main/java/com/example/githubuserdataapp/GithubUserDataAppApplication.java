package com.example.githubuserdataapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@SpringBootApplication
public class GithubUserDataAppApplication implements RepositoryRestConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(GithubUserDataAppApplication.class, args);
    }

}
