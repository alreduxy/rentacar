package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.model.Manufacturer;
import com.aaldama.rentacar.model.Model;
import com.aaldama.rentacar.service.ManufacturerService;
import com.aaldama.rentacar.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelController {

    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public ResponseEntity<List<Model>> findAll() {
        return new ResponseEntity<>(modelService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Model> findById(@PathVariable ("id") Integer id) {
        return new ResponseEntity<>(modelService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Model> save(@RequestBody Model model) {
        return new ResponseEntity<>(modelService.save(model), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable ("id") Integer id) {
        modelService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
