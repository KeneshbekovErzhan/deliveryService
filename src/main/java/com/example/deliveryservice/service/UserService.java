package com.example.deliveryservice.service;

import com.example.deliveryservice.model.Roles;
import com.example.deliveryservice.model.User;
import com.example.deliveryservice.repository.UserRepository;
import com.example.deliveryservice.request.UserSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserSave userSave) {
        User user = new User();
        user.setUserName(userSave.getUserName());
        user.setEmail(userSave.getEmail());
        user.setPhone(userSave.getPhone());
        user.setPassword(userSave.getPassword());
        //      SET ROLE
        switch (userSave.getRole()) {
            case "USER":
                user.setRole(Roles.USER);
                break;
            case "COURIER":
                user.setRole(Roles.COURIER);
                break;
            case "ADMIN":
                user.setRole(Roles.ADMIN);
                break;
        }

        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User getById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void updateUserById(UserSave userSave, Long userId) {
        User userToUpdate = userRepository.findById(userId).orElse(null);
        if (userToUpdate != null) {
            userToUpdate.setUserName(userSave.getUserName());
            userToUpdate.setEmail(userSave.getEmail());
            userToUpdate.setPhone(userSave.getPhone());
            userRepository.save(userToUpdate);
        }
    }
}