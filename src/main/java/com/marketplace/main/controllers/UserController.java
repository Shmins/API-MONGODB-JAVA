package com.marketplace.main.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.RestController;

import com.marketplace.main.models.User;
import com.marketplace.main.services.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user", produces = "application/json")
    public ResponseEntity<?> post(@RequestBody User data) {
        
        try {
            User res = this.userService.create(data);
            return new ResponseEntity<>(res, HttpStatus.valueOf(200));
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.valueOf(500));
        }
    }

    @GetMapping(value = "/user/getAll")
    public ResponseEntity<?> getAll() {
        try {
            List<User> arr = this.userService.findAll();
            return new ResponseEntity<>(arr, HttpStatus.valueOf(200));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(500));
        }
    }

    @GetMapping(value = "/user/id/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        try {
            Optional<User> result = this.userService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.valueOf(200));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(500));
        }
    }

    @GetMapping(value = "/user/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable("name") String name) {
        try {
            List<User> arr = this.userService.findByName(name);
            return new ResponseEntity<>(arr, HttpStatus.valueOf(200));

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(500));
        }
    }

    @GetMapping(value = "/user/email/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable("email") String email) {
        try {
            List<User> arr = this.userService.findByEmail(email);
            return new ResponseEntity<>(arr, HttpStatus.valueOf(200));

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(500));
        }
    }

    @PutMapping(value = "/user/{id}", produces = "application/json")
    public ResponseEntity<?> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        Optional<User> result = this.userService.findById(id);
        if(result.isPresent()){
            User arr = result.get();
            arr.setName(user.getName() != null ? user.getName(): arr.getName());
            arr.setName(user.getEmail() != null ? user.getEmail(): arr.getEmail());
            arr.setName(user.getPassword() != null ? user.getPassword(): arr.getPassword());
            this.userService.update(arr);
            return new ResponseEntity<>(arr, HttpStatus.valueOf(200));
        }
        return null;
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
        try {
            this.userService.delete(id);
            return new ResponseEntity<>(HttpStatus.valueOf(200));

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.valueOf(500));
        }
    }
}
