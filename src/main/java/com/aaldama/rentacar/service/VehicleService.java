package com.aaldama.rentacar.service;

import com.aaldama.rentacar.model.Vehicle;

import java.util.List;

public interface VehicleService {

    public List<Vehicle> findAll();
    public Vehicle findById(Long id);

}
