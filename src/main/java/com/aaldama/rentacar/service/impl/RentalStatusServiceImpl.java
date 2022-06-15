package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.model.RentalStatus;
import com.aaldama.rentacar.repo.RentalStatusRepo;
import com.aaldama.rentacar.service.RentalStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RentalStatusServiceImpl implements RentalStatusService {


    final private RentalStatusRepo rentalStatusRepo;

    @Autowired
    public RentalStatusServiceImpl(RentalStatusRepo rentalStatusRepo) {
        this.rentalStatusRepo = rentalStatusRepo;
    }

    @Override
    public List<RentalStatus> findAll() {
        return rentalStatusRepo.findAll();
    }

    @Override
    public Optional<RentalStatus> findById(Integer id) {
        return rentalStatusRepo.findById(id);
    }

    @Override
    public RentalStatus save(RentalStatus rentalStatus) {
        return rentalStatusRepo.save(rentalStatus);
    }

    @Override
    public RentalStatus update(RentalStatus rentalStatus) {
        return rentalStatusRepo.save(rentalStatus);
    }

    @Override
    public void delete(Integer id) {
        rentalStatusRepo.deleteById(id);
    }
}
