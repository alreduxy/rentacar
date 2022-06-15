package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.exception.ModeloNotFoundException;
import com.aaldama.rentacar.model.Customer;
import com.aaldama.rentacar.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@Valid @PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Customer customer, @PathVariable Long id) {
        Optional<Customer> cu = customerService.findById(id);
        if (cu.isPresent()) {
            Customer customerDb = cu.get();
            customerDb.setFirstName(customer.getFirstName());
            customerDb.setLastName(customer.getLastName());
            customerDb.setEmail(customer.getEmail());

            return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customerDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Customer> cu = customerService.findById(id);
        if (cu.isPresent()) {
            customerService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

