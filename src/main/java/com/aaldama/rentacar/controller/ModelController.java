package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.model.Model;
import com.aaldama.rentacar.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/models")
public class ModelController {

    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public List<Model> findAll() {
        return modelService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@Valid @PathVariable Integer id) {
        Optional<Model> model = modelService.findById(id);
        if (model.isPresent()){
            return ResponseEntity.ok(model.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Model model) {
        return ResponseEntity.status(HttpStatus.CREATED).body(modelService.save(model));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Model model, @PathVariable Integer id) {
        Optional<Model> mo = modelService.findById(id);
        if (mo.isPresent()) {
            Model modelDb = mo.get();
            modelDb.setModelName(model.getModelName());

            return ResponseEntity.status(HttpStatus.CREATED).body(modelService.save(modelDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        Optional<Model> mo = modelService.findById(id);
        if (mo.isPresent()) {
            modelService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
