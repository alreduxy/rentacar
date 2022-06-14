package com.aaldama.rentacar.service;

import com.aaldama.rentacar.model.Manufacturer;
import com.aaldama.rentacar.model.Model;

import java.util.List;

public interface ModelService {

    public List<Model> findAll();
    public Model findById(Integer id);
    public Model save(Model model);
    public void deleteById(Integer id);
    public Manufacturer findManufacturerById(Integer id);
    public List<Manufacturer> findAllManufacturers();
    public Manufacturer saveManufacturer(Manufacturer manufacturer);
}
