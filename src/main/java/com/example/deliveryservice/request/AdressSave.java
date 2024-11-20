package com.example.deliveryservice.request;
import lombok.Data;

@Data
public class AdressSave {

    private Long userId;

    private String city;

    private String street;

    private String houseNumber;

    private String apartment;

    private String postalCode;
}
