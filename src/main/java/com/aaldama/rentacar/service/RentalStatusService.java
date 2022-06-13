package com.aaldama.rentacar.service;

import com.aaldama.rentacar.model.RentalStatus;

import java.util.List;

public interface RentalStatusService  {

    public RentalStatus findById(Integer id);
    public RentalStatus save(RentalStatus rentalStatus);
    public RentalStatus deleteById(Integer id);


}

