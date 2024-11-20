package com.example.deliveryservice.repository;

import com.example.deliveryservice.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress, Long> {
}
