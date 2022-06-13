package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.model.Vehicle;
import com.aaldama.rentacar.repo.VehicleRepo;
import com.aaldama.rentacar.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private final VehicleRepo vehicleRepo;

    public VehicleServiceImpl(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepo.findAll();
    }

    @Override
    public Vehicle findById(Long id) {
        return vehicleRepo.findById(id).orElse(null);
    }
}
