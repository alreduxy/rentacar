package com.aaldama.rentacar.service;

import com.aaldama.rentacar.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    List<Manufacturer> findAll();
    Optional<Manufacturer> findById(Integer id);
    Manufacturer save(Manufacturer manufacturer);
    Manufacturer update(Manufacturer manufacturer);
    void delete(Integer id);
}
