package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.model.Manufacturer;
import com.aaldama.rentacar.repo.ManufacturerRepo;
import com.aaldama.rentacar.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = true)
    public List<Manufacturer> findAll() {
          return manufacturerRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Manufacturer> findById(Integer id) {
        return manufacturerRepo.findById(id);
    }

    @Override
    @Transactional
    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepo.save(manufacturer);
    }

    @Override
    @Transactional
    public Manufacturer update(Manufacturer manufacturer) {
        return manufacturerRepo.save(manufacturer);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        manufacturerRepo.deleteById(id);
    }
}
