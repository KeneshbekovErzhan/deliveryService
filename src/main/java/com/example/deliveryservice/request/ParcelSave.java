package com.example.deliveryservice.request;

import com.example.deliveryservice.model.Adress;
import com.example.deliveryservice.model.Courier;
import com.example.deliveryservice.model.ParcelStatus;
import com.example.deliveryservice.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
