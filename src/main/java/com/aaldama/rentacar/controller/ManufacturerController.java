package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.model.Manufacturer;
import com.aaldama.rentacar.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public List<Manufacturer> findAll() {
        return manufacturerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@Valid @PathVariable Integer id) {
        Optional<Manufacturer> manufacturer = manufacturerService.findById(id);
        if (manufacturer.isPresent()) {
            return ResponseEntity.ok(manufacturer.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Manufacturer manufacturer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(manufacturerService.save(manufacturer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Manufacturer manufacturer, @PathVariable Integer id) {
        Optional<Manufacturer> ma = manufacturerService.findById(id);
        if (ma.isPresent()) {
            Manufacturer manufacturerDb = ma.get();
            manufacturerDb.setName(manufacturer.getName());

            return ResponseEntity.status(HttpStatus.CREATED).body(manufacturerService.save(manufacturerDb));

        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Manufacturer> ma = manufacturerService.findById(id);
        if (ma.isPresent()) {
            manufacturerService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
