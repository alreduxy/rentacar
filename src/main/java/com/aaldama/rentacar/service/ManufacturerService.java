package com.aaldama.rentacar.service;

import com.aaldama.rentacar.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    public List<Manufacturer> findAll();
    public Manufacturer findByName(String name);
    public Manufacturer save(Manufacturer manufacturer);

}
