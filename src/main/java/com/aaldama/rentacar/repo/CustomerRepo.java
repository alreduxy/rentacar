package com.aaldama.rentacar.repo;

import com.aaldama.rentacar.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}

