package com.example.deliveryservice.repository;

import com.example.deliveryservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>  {

    User findByUserName(String username);
}
