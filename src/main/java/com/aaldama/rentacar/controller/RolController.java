package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.model.Role;
import com.aaldama.rentacar.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RolController {

    private final RoleService roleService;

    @Autowired
    public RolController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@Valid @PathVariable Integer id) {
        Optional<Role> role = roleService.findById(id);
        if (role.isPresent()){
            return ResponseEntity.ok(role.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Role role) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.save(role));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Role role, @PathVariable Integer id) {
        Optional<Role> ro = roleService.findById(id);
        if (ro.isPresent()){
            Role roleDb = ro.get();
            roleDb.setName(role.getName());

            return ResponseEntity.status(HttpStatus.CREATED).body(roleService.save(roleDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable ("id") Integer id) {
        Optional<Role> ro = roleService.findById(id);
        if (ro.isPresent()){
            roleService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
