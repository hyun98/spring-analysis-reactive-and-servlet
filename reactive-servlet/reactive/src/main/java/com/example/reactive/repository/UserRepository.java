package com.example.reactive.repository;

import com.example.reactive.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
    
}
