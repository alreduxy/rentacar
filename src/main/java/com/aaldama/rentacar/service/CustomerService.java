package com.aaldama.rentacar.service;

import com.aaldama.rentacar.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer save(Customer customer);
    Customer update(Customer customer);
    void delete(Long id);

}
