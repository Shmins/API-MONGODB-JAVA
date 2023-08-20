package com.marketplace.main.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.main.models.User;
import com.marketplace.main.services.userService;

@RestController
@RequestMapping(path = "/user")
public class userController {

    @Autowired
    private userService UserService;

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> post(@RequestBody User data) {
        try {
            User res = this.UserService.create(data);
            return new ResponseEntity<User>(res, HttpStatus.valueOf(200));
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.valueOf(500));
        }
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        try {
            List<User> arr = this.UserService.findAll();
            return new ResponseEntity<List<User>>(arr, HttpStatus.valueOf(200));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(500));
        }
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        try {
            Optional<User> result = this.UserService.findById(id);
            return new ResponseEntity<Optional<User>>(result, HttpStatus.valueOf(200));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(500));
        }
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getByName(@PathVariable("name") String name) {
        try {
            List<User> arr = this.UserService.findByName(name);
            return new ResponseEntity<List<User>>(arr, HttpStatus.valueOf(200));

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(500));
        }
    }

    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    public ResponseEntity<?> getByEmail(@PathVariable("email") String email) {
        try {
            List<User> arr = this.UserService.findByEmail(email);
            return new ResponseEntity<List<User>>(arr, HttpStatus.valueOf(200));

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(500));
        }
    }

  /*   @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        try {
            User arr = this.UserService.update(id, user);
            return new ResponseEntity<User>(arr, HttpStatus.valueOf(200));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(500));
        }
    } */

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
        System.out.print(id);
        try {
            this.UserService.delete(id);
            return new ResponseEntity<>(HttpStatus.valueOf(200));

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.valueOf(500));
        }
    }
}
