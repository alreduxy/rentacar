package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.dto.RentACarDto;
import com.aaldama.rentacar.model.VehicleRental;
import com.aaldama.rentacar.repo.VehicleRentalRepo;
import com.aaldama.rentacar.service.VehicleRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleRentalServiceImpl implements VehicleRentalService {

    private final VehicleRentalRepo vehicleRentalRepo;

    @Autowired
    public VehicleRentalServiceImpl(VehicleRentalRepo vehicleRentalRepo) {
        this.vehicleRentalRepo = vehicleRentalRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehicleRental> findAll() {
        return vehicleRentalRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<VehicleRental> findById(Integer id) {
        return vehicleRentalRepo.findById(id);
    }

    @Override
    @Transactional
    public VehicleRental save(VehicleRental vehicleRental) {
        return vehicleRentalRepo.save(vehicleRental);
    }

    @Override
    @Transactional
    public VehicleRental update(VehicleRental vehicleRental) {
        return vehicleRentalRepo.save(vehicleRental);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        vehicleRentalRepo.deleteById(id);
    }

    @Override
    public List<RentACarDto> listarVehiculosRentados() {
        List<RentACarDto> listaVehiculos = new ArrayList<>();
        vehicleRentalRepo.listarVehiculosRentados().forEach(x -> {
            RentACarDto dto = new RentACarDto();
            dto.setFullName(String.valueOf(x[0]));
            dto.setEmail(String.valueOf(x[1]));
            dto.setLocationName(String.valueOf(x[2]));
            dto.setVehicleTypeDescription(String.valueOf(x[3]));
            dto.setModelName(String.valueOf(x[4]));
            dto.setDailyHireRate(Long.parseLong(String.valueOf(x[5])));
            dto.setManufacturerName(String.valueOf(x[6]));
            dto.setCurrentKilometers(Integer.parseInt(String.valueOf(x[7])));
            dto.setDateFrom(String.valueOf(x[8]));
            dto.setDateTo(String.valueOf(x[9]));
            dto.setQuantityDays(Integer.parseInt(String.valueOf(x[10])));
            dto.setTotalPrice(Long.parseLong(String.valueOf(x[11])));


            listaVehiculos.add(dto);
        });
        return listaVehiculos;
    }

    @Override
    public List<RentACarDto> listarVehiculosRentadosPorUsuario(Long customer_id) {
        List<RentACarDto> listarPorusuario = new ArrayList<>();
        vehicleRentalRepo.listarVehiculosRentadosPorUsuario(customer_id).forEach(x -> {
            RentACarDto dto = new RentACarDto();
            dto.setFullName(String.valueOf(x[0]));
            dto.setEmail(String.valueOf(x[1]));
            dto.setLocationName(String.valueOf(x[2]));
            dto.setVehicleTypeDescription(String.valueOf(x[3]));
            dto.setModelName(String.valueOf(x[4]));
            dto.setDailyHireRate(Long.parseLong(String.valueOf(x[5])));
            dto.setManufacturerName(String.valueOf(x[6]));
            dto.setCurrentKilometers(Integer.parseInt(String.valueOf(x[7])));
            dto.setDateFrom(String.valueOf(x[8]));
            dto.setDateTo(String.valueOf(x[9]));
            dto.setQuantityDays(Integer.parseInt(String.valueOf(x[10])));
            dto.setTotalPrice(Long.parseLong(String.valueOf(x[11])));


            listarPorusuario.add(dto);
        });
        return listarPorusuario;
    }
}
