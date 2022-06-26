package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.model.Role;
import com.aaldama.rentacar.repo.RoleRepo;
import com.aaldama.rentacar.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return roleRepo.findById(id);
    }

    @Override
    public Role save(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public Role update(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void delete(Integer id) {
        roleRepo.deleteById(id);
    }
}
