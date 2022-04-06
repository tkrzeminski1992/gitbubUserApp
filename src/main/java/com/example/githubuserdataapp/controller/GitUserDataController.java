package com.example.githubuserdataapp.controller;

import com.example.githubuserdataapp.manager.GitApiManager;
import com.example.githubuserdataapp.model.GitUserDataModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitUserDataController {
    private GitApiManager gitApiManager;

    GitUserDataController(GitApiManager gitApiManager) {
        this.gitApiManager = gitApiManager;
    }

    @GetMapping("/user/{id}")
    GitUserDataModel gitUserData(@PathVariable("id") String login){
        return gitApiManager.getGitUserData(login);
    }
}
