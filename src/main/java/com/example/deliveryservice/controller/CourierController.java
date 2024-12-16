package com.example.deliveryservice.controller;

import com.example.deliveryservice.model.Courier;
import com.example.deliveryservice.dto.CourierSave;
import com.example.deliveryservice.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courier")
public class CourierController {

    @Autowired
    private CourierService courierService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CourierSave courierSave){
        courierService.saveCourier(courierSave);
        return ResponseEntity.ok("Courier saved!");
    }

    @GetMapping("/getById/{id}")
    public Courier getById(@PathVariable Long id){
        return courierService.getById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        courierService.deleteById(id);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<?> updateById(@RequestBody CourierSave courierSave, @PathVariable Long id){
        courierService.updateById(courierSave, id);
        return ResponseEntity.ok("Courier updated!");
    }
}
