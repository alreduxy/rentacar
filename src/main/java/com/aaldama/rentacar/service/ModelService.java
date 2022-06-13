package com.aaldama.rentacar.service;

import com.aaldama.rentacar.model.Model;

import java.util.List;

public interface ModelService {

    public Model findById(Integer id);
    public Model save(Model model);
    public List<Model> findAll();
    public void deleteById(Integer id);
}
