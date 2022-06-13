package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.model.Manufacturer;
import com.aaldama.rentacar.repo.ManufacturerRepo;
import com.aaldama.rentacar.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private ManufacturerRepo manufacturerRepo;

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepo.findAll();
    }

    @Override
    public Manufacturer findByName(String name) {
        return null;
    }




    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepo.save(manufacturer);
    }
}
