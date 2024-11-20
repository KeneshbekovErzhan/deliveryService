package com.example.deliveryservice.repository;

import com.example.deliveryservice.model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {
}
