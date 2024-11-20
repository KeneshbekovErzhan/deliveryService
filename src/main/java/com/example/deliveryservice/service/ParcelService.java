package com.example.deliveryservice.service;

import com.example.deliveryservice.model.*;
import com.example.deliveryservice.repository.AdressRepository;
import com.example.deliveryservice.repository.CourierRepository;
import com.example.deliveryservice.repository.ParcelRepository;
import com.example.deliveryservice.repository.UserRepository;
import com.example.deliveryservice.request.ParcelSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParcelService {
    @Autowired
    private ParcelRepository parcelRepository;
    @Autowired
    private CourierRepository courierRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdressRepository adressRepository;

    public void parcelSave(ParcelSave parcelSave){
        Parcel parcel = new Parcel();
        //          SET STATUS
        switch (parcelSave.getParcelStatus()) {
            case "PENDING":
                parcel.setParcelStatus(ParcelStatus.PENDING);
                break;
            case "IN_TRANSIT":
                parcel.setParcelStatus(ParcelStatus.IN_TRANSIT);
                break;
            case "DELIVERED":
                parcel.setParcelStatus(ParcelStatus.DELIVERED);
                break;
            case "CANCELED":
                parcel.setParcelStatus(ParcelStatus.CANCELED);
                break;
        }

        parcel.setEmail(parcelSave.getEmail());
        Courier courier = courierRepository.getReferenceById(parcelSave.getCourierId());
        parcel.setCourierId(courier);
        User user = userRepository.getReferenceById(parcelSave.getUserId());
        parcel.setUserId(user);
        parcel.setWeight(parcelSave.getWeight());
        parcel.setCreationDate(parcelSave.getCreationDate());
        parcel.setDeliveryAdressId(adressRepository.getReferenceById(parcelSave.getDeliveryAdressId()));
        parcel.setPickupAdressId(adressRepository.getReferenceById(parcelSave.getPickupAdressId()));
        parcelRepository.save(parcel);
    }

    public Parcel getById(Long parcelId){
        return parcelRepository.findById(parcelId).orElse(null);
    }

    public void deleteById(Long parcelId){
        parcelRepository.deleteById(parcelId);
    }

    public void updateById(ParcelSave parcelSave, Long parcelId){
        Parcel parcelToUpdate = parcelRepository.findById(parcelId).orElse(null);
        if(parcelToUpdate != null){
            parcelToUpdate.setParcelStatus(ParcelStatus.valueOf(parcelSave.getParcelStatus()));
            parcelToUpdate.setEmail(parcelSave.getEmail());
            Courier courier = courierRepository.getReferenceById(parcelSave.getCourierId());
            parcelToUpdate.setCourierId(courier);
            User user = userRepository.getReferenceById(parcelSave.getUserId());
            parcelToUpdate.setUserId(user);
            parcelToUpdate.setWeight(parcelSave.getWeight());
            parcelToUpdate.setCreationDate(parcelSave.getCreationDate());
            parcelToUpdate.setDeliveryAdressId(adressRepository.getReferenceById(parcelSave.getDeliveryAdressId()));
            parcelToUpdate.setPickupAdressId(adressRepository.getReferenceById(parcelSave.getPickupAdressId()));
            parcelRepository.save(parcelToUpdate);
        }

    }
}
