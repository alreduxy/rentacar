package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.model.RentalStatus;
import com.aaldama.rentacar.service.RentalStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rental-status")
public class RentalStatusController {

    private final RentalStatusService rentalStatusService;

    @Autowired
    public RentalStatusController(RentalStatusService rentalStatusService) {
        this.rentalStatusService = rentalStatusService;
    }

    @GetMapping
    public List<RentalStatus> findAll() {
        return rentalStatusService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@Valid @PathVariable Integer id) {
        Optional<RentalStatus> rentalStatus = rentalStatusService.findById(id);
        if (rentalStatus.isPresent()){
            return ResponseEntity.ok(rentalStatus.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody RentalStatus rentalStatus) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rentalStatusService.save(rentalStatus));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody RentalStatus rentalStatus, @PathVariable Integer id) {
        Optional<RentalStatus> rs = rentalStatusService.findById(id);
        if (rs.isPresent()){
            RentalStatus rentalStatusDb = rs.get();
            rentalStatusDb.setName(rentalStatus.getName());

            return ResponseEntity.status(HttpStatus.CREATED).body(rentalStatusService.save(rentalStatusDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        Optional<RentalStatus> rs = rentalStatusService.findById(id);
        if (rs.isPresent()){
            rentalStatusService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
