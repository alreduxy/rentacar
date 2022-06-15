package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.model.Location;
import com.aaldama.rentacar.repo.LocationRepo;
import com.aaldama.rentacar.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepo locationRepo;

    @Autowired
    public LocationServiceImpl(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Location> findAll() {
        return locationRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Location> findById(Integer id) {
        return locationRepo.findById(id);
    }

    @Override
    @Transactional
    public Location save(Location location) {
        return locationRepo.save(location);
    }

    @Override
    @Transactional
    public Location update(Location location) {
        return locationRepo.save(location);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        locationRepo.deleteById(id);
    }
}




