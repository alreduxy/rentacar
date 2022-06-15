package com.aaldama.rentacar.service;

import com.aaldama.rentacar.model.RentalStatus;

import java.util.List;
import java.util.Optional;

public interface RentalStatusService  {

    List<RentalStatus> findAll();
    Optional<RentalStatus> findById(Integer id);
    RentalStatus save(RentalStatus rentalStatus);
    RentalStatus update(RentalStatus rentalStatus);
    void delete(Integer id);


}

