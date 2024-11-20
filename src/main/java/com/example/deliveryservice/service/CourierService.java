package com.example.deliveryservice.service;

import com.example.deliveryservice.model.Courier;
import com.example.deliveryservice.repository.CourierRepository;
import com.example.deliveryservice.request.CourierSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourierService {
    @Autowired
    private CourierRepository courierRepository;

    public void saveCourier(CourierSave courierSave){
        Courier courier = new Courier();
        courier.setUserName(courierSave.getUserName());
        courier.setEmail(courierSave.getEmail());
        courier.setPhone(courierSave.getPhone());
        courier.setPassword(courierSave.getPassword());
        courierRepository.save(courier);
    }

    public Courier getById(Long courierId){
        return courierRepository.findById(courierId).orElse(null);
    }

    public void deleteById(Long courierId){
        courierRepository.findById(courierId);
    }

    public void updateById(CourierSave courierSave, Long courierId){
        Courier courierToUpdate = courierRepository.getReferenceById(courierId);
        if(courierToUpdate != null){
            courierToUpdate.setUserName(courierSave.getUserName());
            courierToUpdate.setEmail(courierSave.getEmail());
            courierToUpdate.setPhone(courierSave.getPhone());
            courierRepository.save(courierToUpdate);
        }
    }



}
