package com.example.deliveryservice.request;

import lombok.Data;

import java.util.Date;

@Data
public class ParcelSave {
    private Long userId;

    private Long courierId;

    private String email;

    private String parcelStatus;

    private Date creationDate;

    private Long pickupAdressId;

    private Long deliveryAdressId;

    private double weight;
}
