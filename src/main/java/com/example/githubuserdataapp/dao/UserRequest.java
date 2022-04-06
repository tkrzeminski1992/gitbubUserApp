package com.example.githubuserdataapp.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "USER_REQUEST")
public class UserRequest {
    @Id
    @NotBlank(message = "Login nie może być pusty")
    @Column(name="LOGIN")
    private String login;

    @Column(name = "REQUEST_COUNT")
    private Integer requestCount;

    public UserRequest() {
    }

    public UserRequest(String login) {
        this.login = login;
        this.requestCount = 1;
    }

    public void incrementRequestCount(){
        requestCount++;
    }
}
