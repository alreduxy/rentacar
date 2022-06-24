package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.dto.VehicleRentalDTO;
import com.aaldama.rentacar.model.VehicleRental;
import com.aaldama.rentacar.service.UserService;
import com.aaldama.rentacar.service.VehicleRentalService;
import com.aaldama.rentacar.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle-rented")
public class VehicleRentalsController {
    @Autowired
    VehicleRentalService vehicleRentalService;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    UserService userService;

    @GetMapping
    public List<VehicleRental> findAll() {
        return vehicleRentalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@Valid @PathVariable Integer id) {
        Optional<VehicleRental> vehicleRental = vehicleRentalService.findById(id);
        if (vehicleRental.isPresent()){
            return ResponseEntity.ok(vehicleRental.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody VehicleRental vehicleRental) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleRentalService.save(vehicleRental));

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<VehicleRental> vr = vehicleRentalService.findById(id);
        if (vr.isPresent()) {
            vehicleRentalService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/rentados/{id}")
    public ResponseEntity<List<VehicleRentalDTO>> listVehicleByUserId(@PathVariable ("id") Integer idUser) {
        Optional<VehicleRental> vr = vehicleRentalService.findById(idUser);
        if (vr.isPresent()) {
            List<VehicleRentalDTO> vrdto = vehicleRentalService.listVehicleByUserId(idUser);
            return ResponseEntity.ok(vehicleRentalService.listVehicleByUserId(idUser));
            }
        return ResponseEntity.notFound().build();
    }


}
