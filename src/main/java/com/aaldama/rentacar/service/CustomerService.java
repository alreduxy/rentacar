package com.aaldama.rentacar.service;

import com.aaldama.rentacar.model.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAll();
    public Customer findById(Integer id);
    public Customer save(Customer customer);
    public void delete(Integer id);

}
