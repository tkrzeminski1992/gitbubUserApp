package com.example.githubuserdataapp.manager;

import com.example.githubuserdataapp.dao.UserRequest;
import com.example.githubuserdataapp.dao.UserRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRequestManager {

    private UserRequestRepo userRequestRepo;

    @Autowired
    public UserRequestManager(UserRequestRepo userRequestRepo) {
        this.userRequestRepo = userRequestRepo;
    }

    public UserRequest save(String login){
        UserRequest userRequest;
        if(userRequestRepo.existsById(login)){
            userRequest = userRequestRepo.findById(login).get();
            userRequest.incrementRequestCount();
        }else{
            userRequest = new UserRequest(login);
        }
        return userRequestRepo.save(userRequest);

    }


}
