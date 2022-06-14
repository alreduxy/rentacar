package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.exception.ModeloNotFoundException;
import com.aaldama.rentacar.model.Customer;
import com.aaldama.rentacar.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List<Customer>> findAll() {
        return new ResponseEntity<List<Customer>>(customerService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable ("id") Long id) {
        Optional<Customer> customer = Optional.ofNullable(customerService.findById(id));
        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseThrow(() -> new ModeloNotFoundException(HttpStatus.NOT_FOUND, "Customer not found"));
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@RequestBody Customer customer, @PathVariable ("id") Long id) {
        Customer custom = customerService.findById(id);
        custom.setEmail(customer.getEmail());
        return customerService.save(custom);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ("id") Long id) {
        customerService.delete(id);
    }

}

