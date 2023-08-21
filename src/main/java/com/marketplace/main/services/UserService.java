package com.marketplace.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.main.models.User;
import com.marketplace.main.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(User data) {
        return this.userRepository.insert(data);
    }

    public Optional<User> findById(String id) {
        return this.userRepository.findById(id);
    }

    public List<User> findByName(String name) {
        return this.userRepository.findByName(name);
    }

    public List<User> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
    public User update(User data){
        return this.userRepository.save(data);
    }
    public List<User> findAll() {
        return this.userRepository.findAll();
    }


    public void delete(String id) {
        this.userRepository.deleteById(id);
    }

}
