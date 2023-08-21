package com.marketplace.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


import com.marketplace.main.models.User;

@EnableMongoRepositories
public interface UserRepository extends MongoRepository<User, String> {
      /* Filter: id, name and email */
      Optional<User> findById(String id);
      List<User> findByName(String name);
      List<User> findByEmail(String email);
      /* Filter: Created and Change*/
}
