package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.dto.RentACarDto;
import com.aaldama.rentacar.model.VehicleRental;
import com.aaldama.rentacar.service.VehicleRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/list-rented")
public class VehicleRentalsController {

    private final VehicleRentalService vehicleRentalService;

    @Autowired
    public VehicleRentalsController(VehicleRentalService vehicleRentalService) {
        this.vehicleRentalService = vehicleRentalService;
    }

//    @GetMapping
//    public List<VehicleRental> findAll() {
//        return vehicleRentalService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> findById(@Valid @PathVariable Integer id) {
//        Optional<VehicleRental> vehicleRental = vehicleRentalService.findById(id);
//        if (vehicleRental.isPresent()){
//            return ResponseEntity.ok(vehicleRental.get());
//        }
//        return ResponseEntity.notFound().build();
//    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody VehicleRental vehicleRental) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleRentalService.save(vehicleRental));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody VehicleRental vehicleRental, @PathVariable Integer id) {
        Optional<VehicleRental> vr = vehicleRentalService.findById(id);
        if (vr.isPresent()) {
            VehicleRental vehicleRentalDb = vr.get();
            vehicleRentalDb.setDateFrom(vehicleRental.getDateFrom());
            vehicleRentalDb.setDateTo(vehicleRental.getDateTo());

            return ResponseEntity.status(HttpStatus.CREATED).body(vehicleRentalService.save(vehicleRentalDb));
        }
        return ResponseEntity.notFound().build();
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

    @GetMapping()
    public ResponseEntity<List<RentACarDto>> listarVehiculosRentados() {
        List<RentACarDto> lista = new ArrayList<>();
        lista = vehicleRentalService.listarVehiculosRentados();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<RentACarDto>> listarVehiculosRentadosPorUsuario(@PathVariable ("id") Long id) {
        List<RentACarDto> lista = new ArrayList<>();
        lista = vehicleRentalService.listarVehiculosRentadosPorUsuario(id);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }


}
