package com.aaldama.rentacar.service;

import com.aaldama.rentacar.dto.RentACarDto;
import com.aaldama.rentacar.model.VehicleRental;

import java.util.List;
import java.util.Optional;

public interface VehicleRentalService {

    List<VehicleRental> findAll();
    Optional<VehicleRental> findById(Integer id);
    VehicleRental save(VehicleRental vehicleRental);
    VehicleRental update(VehicleRental vehicleRental);
    void delete(Integer id);
    List<RentACarDto> listarVehiculosRentados();
    List<RentACarDto> listarVehiculosRentadosPorUsuario(Long customer_id);

}