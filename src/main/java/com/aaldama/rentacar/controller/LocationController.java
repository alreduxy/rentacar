package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.exception.ModeloNotFoundException;
import com.aaldama.rentacar.model.Location;
import com.aaldama.rentacar.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> findAll() {
        return locationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@Valid @PathVariable Integer id) {
        Optional<Location> location = locationService.findById(id);
        if (location.isPresent()){
            return ResponseEntity.ok(location.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Location location) {
        return ResponseEntity.status(HttpStatus.CREATED).body(locationService.save(location));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Location location, @PathVariable Integer id) {
        Optional<Location> lo = locationService.findById(id);
        if (lo.isPresent()){
            Location locationDb = lo.get();
            locationDb.setLocationCode(location.getLocationCode());
            locationDb.setLocationName(location.getLocationName());

            return ResponseEntity.status(HttpStatus.CREATED).body(locationService.save(locationDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable ("id") Integer id) {
        Optional<Location> lo = locationService.findById(id);
        if (lo.isPresent()){
            locationService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
