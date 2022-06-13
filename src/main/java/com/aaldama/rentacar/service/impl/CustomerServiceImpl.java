package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.model.Customer;
import com.aaldama.rentacar.repo.CustomerRepo;
import com.aaldama.rentacar.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findById(Integer id) {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
