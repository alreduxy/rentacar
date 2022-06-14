package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.dto.RentACarDto;
import com.aaldama.rentacar.service.VehicleRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleRentalsController {

    private final VehicleRentalService vehicleRentalService;

    @Autowired
    public VehicleRentalsController(VehicleRentalService vehicleRentalService) {
        this.vehicleRentalService = vehicleRentalService;
    }

    @GetMapping("/listar-rentados")
    public ResponseEntity<List<RentACarDto>> listarVehiculosRentados() {
        List<RentACarDto> lista = new ArrayList<>();
        lista = vehicleRentalService.listarVehiculosRentados();
        return new ResponseEntity<List<RentACarDto>>(lista, HttpStatus.OK);
    }

    @GetMapping("/listar-rentados/{customer_id}")
    public ResponseEntity<List<RentACarDto>> listarVehiculosRentadosPorUsuario(@PathVariable ("customer_id") Long customer_id) {
        List<RentACarDto> lista = new ArrayList<>();
        lista = vehicleRentalService.listarVehiculosRentadosPorUsuario(customer_id);
        return new ResponseEntity<List<RentACarDto>>(lista, HttpStatus.OK);
    }


}
