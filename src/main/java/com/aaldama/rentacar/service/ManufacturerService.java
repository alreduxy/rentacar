package com.aaldama.rentacar.service;

import com.aaldama.rentacar.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    public List<Manufacturer> findAll();
    public Manufacturer findById(Integer id);
    public Manufacturer save(Manufacturer manufacturer);
    public Manufacturer update(Manufacturer manufacturer);
    public Manufacturer delete(Integer id);
}
