package com.miniproject.digital_library.controller;

import com.miniproject.digital_library.entity.UserEntity;
import com.miniproject.digital_library.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity){
      UserEntity userEntity1 =  this.userService.addUser(userEntity);
      return new  ResponseEntity<>(userEntity1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable int id){
       UserEntity userEntity = this.userService.getUser(id);
       return new ResponseEntity<>(userEntity,HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable int id,@RequestBody UserEntity userEntity){
        UserEntity updatedUser = this.userService.updateUser(id, userEntity);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id){
        this.userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
