package com.example.githubuserdataapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRequestRepo extends JpaRepository<UserRequest,String> {

}
