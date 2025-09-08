package com.stride.controller;

import jakarta.validation.Valid;

import com.stride.model.User; //Import user entity
import com.stride.repository.UserRepository; //Import repository

import org.springframework.web.bind.annotation.*; //Annotations for REST
import org.springframework.http.ResponseEntity; //Wrapper for HTTP responses

import java.util.List;

@RestController //Marks class as the REST Controller

@RequestMapping("/api/users") //All endpoints begin with this syntax



public class UserController {
    private final UserRepository userRepository; //Must be assigned in the constructor (no reassignment)

    //Constructor injection
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //Get all users
    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll(); //Returns as JSON array
    }

    //Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return userRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }
    //Create user
    @PostMapping //Handles post requests
    public User createUser(@Valid @RequestBody User user){ //Takes JSON and parses into User object
        //@Valid checks the validation
        return userRepository.save(user); //If id is null adds, if it exists it updates
    }

    //Update user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User userDetails ){
        return userRepository.findById(id).map(user ->{
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            return ResponseEntity.ok(userRepository.save(user));

        })
                .orElse(ResponseEntity.notFound().build());

    }

    //Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        return userRepository.findById(id).map(user -> {userRepository.delete(user);
        return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());

    }


}
