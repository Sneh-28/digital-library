package com.miniproject.digital_library.repository.impl;

import com.miniproject.digital_library.entity.UserEntity;
import com.miniproject.digital_library.repository.jpa.UserJpaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Repository
public class UserRepo {
    private final UserJpaRepo userJpaRepo;

    public UserRepo(UserJpaRepo userJpaRepo) {
        this.userJpaRepo = userJpaRepo;
    }

    //create
    public UserEntity addUser(UserEntity userEntity){
        return this.userJpaRepo.save(userEntity);
    }

    //read
    public UserEntity getUser(int id){
        return this.userJpaRepo.findById(id).orElse(null);
    }

    //update
    public UserEntity updateUser(UserEntity userEntity){
        return this.userJpaRepo.save(userEntity);
    }


    //delete
    public void deleteUser(int id){
        this.userJpaRepo.deleteById(id);
    }

    public Optional<UserEntity> getUserByEmail(String email) {
        return this.userJpaRepo.findByEmail(email);
    }



}
