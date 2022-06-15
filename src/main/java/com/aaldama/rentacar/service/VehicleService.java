package com.aaldama.rentacar.service;

import com.aaldama.rentacar.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    List<Vehicle> findAll();
    Optional<Vehicle> findById(Integer id);
    Vehicle save(Vehicle vehicle);
    Vehicle update(Vehicle vehicle);
    void delete(Integer id);

}
