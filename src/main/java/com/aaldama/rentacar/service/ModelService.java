package com.aaldama.rentacar.service;

import com.aaldama.rentacar.model.Manufacturer;
import com.aaldama.rentacar.model.Model;

import java.util.List;
import java.util.Optional;

public interface ModelService {

    List<Model> findAll();
    Optional<Model> findById(Integer id);
    Model save(Model model);
    Model update(Model model);
    void delete(Integer id);

}
