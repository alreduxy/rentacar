package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.model.Vehicle;
import com.aaldama.rentacar.repo.VehicleRepo;
import com.aaldama.rentacar.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepo vehicleRepo;

    @Autowired
    public VehicleServiceImpl(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return vehicleRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Vehicle> findById(Integer id) {
        return vehicleRepo.findById(id);
    }

    @Override
    @Transactional
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    @Override
    @Transactional
    public Vehicle update(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        vehicleRepo.deleteById(id);

    }
}
