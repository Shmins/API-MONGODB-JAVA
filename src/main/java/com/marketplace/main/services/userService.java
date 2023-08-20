package com.marketplace.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.main.models.User;
import com.marketplace.main.repository.userRepository;

@Service
public class userService {
    @Autowired
    private userRepository UserRepository;

    public User create(User data) {
        return this.UserRepository.insert(data);
    }

    public Optional<User> findById(String id) {
        Optional<User> user = this.UserRepository.findById(id);
        if (user.isEmpty()) {
            return null;
        } else {
            return user;
        }
    }

    public List<User> findByName(String name) {
        return this.UserRepository.findByName(name);
    }

    public List<User> findByEmail(String email) {
        return this.UserRepository.findByEmail(email);
    }

    public List<User> findAll() {
        return this.UserRepository.findAll();
    }

   /*  public User update(String id, User data) {
        return this.UserRepository.putUser(id, data);
    } */

    public void delete(String id) {
        this.UserRepository.deleteById(id);
    }

}
