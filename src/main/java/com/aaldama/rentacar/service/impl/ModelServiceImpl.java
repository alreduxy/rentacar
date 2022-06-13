package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.model.Model;
import com.aaldama.rentacar.repo.ModelRepo;
import com.aaldama.rentacar.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepo modelRepo;

    @Override
    public Model findById(Integer id) {
        return modelRepo.findById(id).orElse(null);
    }

    @Override
    public Model save(Model model) {
        return modelRepo.save(model);
    }

    @Override
    public List<Model> findAll() {
        return modelRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        modelRepo.deleteById(id);
    }


}
