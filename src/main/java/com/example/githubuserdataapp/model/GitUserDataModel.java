package com.example.githubuserdataapp.model;

import com.fasterxml.jackson.annotation.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class GitUserDataModel {

    private Integer id;

    private String login;

    private String name;

    private String type;

    private HttpStatus status;

    @JsonAlias("avatar_url")
    private String avatarUrl;

    @JsonAlias("created_at")
    private LocalDate createdAt;

    private Float calculations;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer followers;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonAlias("public_repos")
    private Integer publicRepos;

    public GitUserDataModel() {
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Float getCalculations() {
        return calculations;
    }

    public Integer getFollowers() {
        return followers;
    }

    public Integer getPublicRepos() {
        return publicRepos;
    }

    public void setCalculations(Float calculations) {
        this.calculations = calculations;
    }

    @Override
    public String toString() {
        return "GitUserDataModel{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", createdAt=" + createdAt +
                ", calculations=" + calculations +
                '}';
    }
}
