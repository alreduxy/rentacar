package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.model.Manufacturer;
import com.aaldama.rentacar.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/all")
    public List<Manufacturer> index() {
        return manufacturerService.findAll();
    }


    @PostMapping("/save")
    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerService.save(manufacturer);
    }


}
