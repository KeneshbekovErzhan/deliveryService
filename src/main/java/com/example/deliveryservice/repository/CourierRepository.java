package com.example.deliveryservice.repository;

import com.example.deliveryservice.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier, Long> {
}
