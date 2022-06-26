package com.aaldama.rentacar.service;

import com.aaldama.rentacar.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    public List<Role> findAll();
    public Optional<Role> findById(Integer id);
    public Role save(Role role);
    public Role update(Role role);
    public void delete(Integer id);


}

