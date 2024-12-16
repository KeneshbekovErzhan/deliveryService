package com.example.deliveryservice.dto;
import lombok.Data;

@Data
public class UserSave {

    private  String userName;

    private String email;

    private String password;

    private String phone;

    private Long id;
}
