package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.model.RentalStatus;
import com.aaldama.rentacar.model.Vehicle;
import com.aaldama.rentacar.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> findAll() {
        return vehicleService.findAll()
                .stream()
                .filter(vehicle -> vehicle.getRentalStatus().getIdRentalStatus().equals(RentalStatus.AVAILABLE)).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@Valid @PathVariable Integer id) {
        Optional<Vehicle> vehicle = vehicleService.findById(id);
        if (vehicle.isPresent()) {
            return ResponseEntity.ok(vehicle.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Vehicle vehicle) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.save(vehicle));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Vehicle vehicle, @PathVariable Integer id) {
        Optional<Vehicle> ve = vehicleService.findById(id);
        if (ve.isPresent()) {
            Vehicle vehicleDb = ve.get();
            vehicleDb.setCurrentKilometers(vehicle.getCurrentKilometers());
            vehicleDb.setPlate(vehicle.getPlate());
            vehicleDb.setColor(vehicle.getColor());
            vehicleDb.setFullTank(vehicle.getFullTank());
            vehicleDb.setModel(vehicle.getModel());

            return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.save(vehicleDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Vehicle> ve = vehicleService.findById(id);
        if (ve.isPresent()) {
            vehicleService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
