package com.example.deliveryservice.service;

import com.example.deliveryservice.model.Adress;
import com.example.deliveryservice.model.User;
import com.example.deliveryservice.repository.AdressRepository;
import com.example.deliveryservice.repository.UserRepository;
import com.example.deliveryservice.dto.AdressSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdressService {
    @Autowired
    private AdressRepository adressRepository;
    @Autowired
    private UserRepository userRepository;
    public void adressSave(AdressSave adressSave){
        Adress adress = new Adress();
        adress.setCity(adressSave.getCity());
        adress.setApartment(adressSave.getApartment());
        adress.setStreet(adressSave.getStreet());
        adress.setHouseNumber(adressSave.getHouseNumber());
        adress.setPostalCode(adressSave.getPostalCode());
        User user = userRepository.getReferenceById(adressSave.getUserId());
        adress.setUserId(user);
        adressRepository.save(adress);
    }

    public void deleteById(Long adressId){
        adressRepository.deleteById(adressId);
    }

    public Adress getById(Long adressId){
        return adressRepository.findById(adressId).orElse(null);
    }

    public void updateById(AdressSave adressSave, Long adressId){
        Adress adressToUpdate = adressRepository.getReferenceById(adressId);
        if(adressToUpdate != null){
            adressToUpdate.setCity(adressSave.getCity());
            adressToUpdate.setApartment(adressSave.getApartment());
            adressToUpdate.setStreet(adressSave.getStreet());
            adressToUpdate.setHouseNumber(adressSave.getHouseNumber());
            adressToUpdate.setPostalCode(adressSave.getPostalCode());
            User user = userRepository.getReferenceById(adressSave.getUserId());
            adressToUpdate.setUserId(user);
            adressRepository.save(adressToUpdate);
        }
    }

}
