package com.aaldama.rentacar.service;

import com.aaldama.rentacar.dto.RentACarDto;
import com.aaldama.rentacar.model.VehicleRental;

import java.util.List;

public interface VehicleRentalService {

    public List<RentACarDto> listarVehiculosRentados();
    public List<RentACarDto> listarVehiculosRentadosPorUsuario(Integer user_id);

}