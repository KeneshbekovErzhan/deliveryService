package com.example.deliveryservice.service;

import com.example.deliveryservice.model.User;
import com.example.deliveryservice.repository.UserRepository;
import com.example.deliveryservice.dto.UserSave;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;


    public void saveUser(UserSave userSave) {
        User user = new User();
        user.setUserName(userSave.getUserName());
        user.setEmail(userSave.getEmail());
        user.setPhone(userSave.getPhone());
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}