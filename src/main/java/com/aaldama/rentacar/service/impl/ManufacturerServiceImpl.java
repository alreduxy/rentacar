package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.model.Manufacturer;
import com.aaldama.rentacar.repo.ManufacturerRepo;
import com.aaldama.rentacar.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private final ManufacturerRepo manufacturerRepo;


    public ManufacturerServiceImpl(ManufacturerRepo manufacturerRepo) {
        this.manufacturerRepo = manufacturerRepo;
    }

    @Override
    public List<Manufacturer> findAll() {
          return manufacturerRepo.findAll();
    }

    @Override
    public Manufacturer findById(Integer id) {
        Optional<Manufacturer> manufacturer = manufacturerRepo.findById(id);
        return manufacturer.orElseThrow(() -> new UsernameNotFoundException(String.format("Manufacturer does not exist", id)));
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        return null;
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        return null;
    }

    @Override
    public Manufacturer delete(Integer id) {
        return null;
    }
}
