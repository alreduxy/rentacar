package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.model.RentalStatus;
import com.aaldama.rentacar.repo.RentalStatusRepo;
import com.aaldama.rentacar.service.RentalStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RentalStatusServiceImpl implements RentalStatusService {

    @Autowired
    private RentalStatusRepo rentalStatusRepo;

    @Override
    public RentalStatus findById(Integer id) {
        return rentalStatusRepo.findById(id).orElse(null);
    }

    @Override
    public RentalStatus save(RentalStatus rentalStatus) {
        return rentalStatusRepo.save(rentalStatus);
    }

    @Override
    public RentalStatus deleteById(Integer id) {
        rentalStatusRepo.deleteById(id);
        return null;
    }


}
