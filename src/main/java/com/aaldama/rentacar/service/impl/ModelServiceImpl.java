package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.model.Model;
import com.aaldama.rentacar.repo.ModelRepo;
import com.aaldama.rentacar.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepo modelRepo;

    @Autowired
    public ModelServiceImpl(ModelRepo modelRepo) {
        this.modelRepo = modelRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Model> findAll() {
        return modelRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Model> findById(Integer id) {
        return modelRepo.findById(id);
    }

    @Override
    @Transactional
    public Model save(Model model) {
        return modelRepo.save(model);
    }

    @Override
    @Transactional
    public Model update(Model model) {
        return modelRepo.save(model);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        modelRepo.deleteById(id);
    }
}
