package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.model.Manufacturer;
import com.aaldama.rentacar.model.Model;
import com.aaldama.rentacar.repo.ManufacturerRepo;
import com.aaldama.rentacar.repo.ModelRepo;
import com.aaldama.rentacar.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepo modelRepo;

    private final ManufacturerRepo manufacturerRepo;

    @Autowired
    public ModelServiceImpl(ModelRepo modelRepo, ManufacturerRepo manufacturerRepo) {
        this.modelRepo = modelRepo;
        this.manufacturerRepo = manufacturerRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Model> findAll() {
        return modelRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Model findById(Integer id) {
        return modelRepo.findById(id).orElseThrow(() -> new RuntimeException("Model does not exist"));
    }

    @Override
    @Transactional
    public Model save(Model model) {
        return modelRepo.save(model);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        modelRepo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Manufacturer findManufacturerById(Integer id) {
        return manufacturerRepo.findById(id).orElseThrow(() -> new RuntimeException("Manufacturer does not exist"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Manufacturer> findAllManufacturers() {
        return manufacturerRepo.findAll();
    }

    @Override
    @Transactional
    public Manufacturer saveManufacturer(Manufacturer manufacturer) {
        return manufacturerRepo.save(manufacturer);
    }
}
