package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.model.Manufacturer;
import com.aaldama.rentacar.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(manufacturerService.findAll(), org.springframework.http.HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manufacturer> findById(@PathVariable ("id") Integer id) {
        return new ResponseEntity<>(manufacturerService.findById(id), org.springframework.http.HttpStatus.OK);
    }


}
