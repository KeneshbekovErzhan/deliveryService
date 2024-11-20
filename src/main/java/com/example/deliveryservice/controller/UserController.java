package com.example.deliveryservice.controller;

import com.example.deliveryservice.model.User;
import com.example.deliveryservice.repository.UserRepository;
import com.example.deliveryservice.request.UserSave;
import com.example.deliveryservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserSave userSave){
        userService.saveUser(userSave);
        return ResponseEntity.ok("User saved!");
    }

    @GetMapping("/getById/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PutMapping("/updateById/{userId}")
    public ResponseEntity<?> updateById(@RequestBody UserSave userSave, @PathVariable Long userId){
        userService.updateUserById(userSave, userId);
        return ResponseEntity.ok("User updated!");
    }
}
