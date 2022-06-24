package com.aaldama.rentacar.service;

import com.aaldama.rentacar.dto.VehicleRentalDTO;
import com.aaldama.rentacar.model.Vehicle;
import com.aaldama.rentacar.model.VehicleRental;

import java.util.List;
import java.util.Optional;

public interface VehicleRentalService {

    List<VehicleRental> findAll();
    Optional<VehicleRental> findById(Integer id);
    VehicleRental save(VehicleRental vehicleRental) throws Exception;
    void delete(Integer id);
    List<VehicleRentalDTO> listVehicleByUserId(int idUser);
    public Vehicle updateVehicle(Vehicle vehicle);


}