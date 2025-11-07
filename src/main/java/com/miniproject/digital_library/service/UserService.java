package com.miniproject.digital_library.service;

import com.miniproject.digital_library.entity.UserEntity;
import com.miniproject.digital_library.repository.impl.UserRepo;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserEntity addUser(UserEntity userEntity){
        userRepo.getUserByEmail(userEntity.getEmail()).ifPresent(existingEmail -> {
             throw new ResponseStatusException
                     (HttpStatus.BAD_REQUEST,"Email already exist" + userEntity.getEmail());
        });
        return this.userRepo.addUser(userEntity);
    }

    public UserEntity getUser(int id){
        return this.userRepo.getUser(id);
    }

    public UserEntity updateUser(int id,UserEntity userEntity){
        UserEntity existingUser = userRepo.getUser(id);
        existingUser.setFirstName(userEntity.getFirstName());
        existingUser.setLastName(userEntity.getLastName());
        existingUser.setBirthDate(userEntity.getBirthDate());
        existingUser.setEmail(userEntity.getEmail());
        existingUser.setSubscriptionType(userEntity.getSubscriptionType());

        return userRepo.updateUser(existingUser);

    }

    public void deleteUser(int id){
        this.userRepo.deleteUser(id);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       try {
           Optional<UserEntity> user = this.userRepo.getUserByEmail(username);
           UserDetails userDetails = User.withUsername(user.get().getEmail())
                   .password(user.get().getPassword())
                   .build();
           return userDetails;
       }
        catch(Exception e){
           throw new UsernameNotFoundException("User not found");
       }
    }
    }

