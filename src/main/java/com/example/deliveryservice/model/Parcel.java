package com.example.deliveryservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "parcel")
public class Parcel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parcelId;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "courierId", referencedColumnName = "courierId")
    private Courier courierId;

    @Column(name = "email")
    private String email;

    @Column(name = "parcel_status")
    private ParcelStatus parcelStatus;

    @Column(name = "creation_date")
    private Date creationDate;

    @OneToOne
    @JoinColumn(name = "pickupAdressId", referencedColumnName = "adressId")
    private Adress pickupAdressId;

    @OneToOne
    @JoinColumn(name = "deliveryAdressId", referencedColumnName = "adressId")
    private Adress deliveryAdressId;

    @Column(name = "weight")
    private double weight;
}
