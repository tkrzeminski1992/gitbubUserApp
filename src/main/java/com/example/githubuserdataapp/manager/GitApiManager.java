package com.example.githubuserdataapp.manager;

import com.example.githubuserdataapp.model.GitUserDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class GitApiManager {
    private final UserRequestManager userRequestManager;
    private RestTemplate restTemplate;

    @Autowired
    public GitApiManager(UserRequestManager userRequestManager, RestTemplateBuilder restTemplateBuilder) {
        this.userRequestManager = userRequestManager;
        restTemplate = restTemplateBuilder
                .errorHandler(new GitApiRestTemplateResponseErrorHandler())
                .build();
    }

    public GitUserDataModel getGitUserData(String login) {
        userRequestManager.save(login);

        GitUserDataModel result = connectToGitApi(login);
        result.setCalculations(getCalculateParamValue(result.getFollowers(), result.getPublicRepos()));
        return result;
    }

    public GitUserDataModel connectToGitApi(String login) {
        HashMap<String, String> map = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity;
        ResponseEntity<GitUserDataModel> result;

        map.put("login",login);

        entity = new HttpEntity<>("body", headers);
        result  = restTemplate.exchange("https://api.github.com/users/{login}", HttpMethod.GET, entity,  GitUserDataModel.class, map);

        return result.getBody();
    }

    public float getCalculateParamValue(Integer followers, Integer publicRepo){
        float result = 0F;
        if(publicRepo == null){
            publicRepo = 0;
        }

        if(followers!=null && followers !=0){
            result = 6 / followers.floatValue() * (2 + publicRepo);
        }

        return result;
    }
}
