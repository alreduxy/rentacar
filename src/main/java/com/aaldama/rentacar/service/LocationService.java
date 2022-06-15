package com.aaldama.rentacar.service;

import com.aaldama.rentacar.model.Location;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface LocationService {

    List<Location> findAll();
    Optional<Location> findById(Integer id);
    Location save(Location location);
    Location update(Location location);
    void delete(Integer id);

}

