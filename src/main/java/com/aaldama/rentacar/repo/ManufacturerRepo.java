package com.aaldama.rentacar.repo;

import com.aaldama.rentacar.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepo extends JpaRepository<Manufacturer, Integer> {

}
