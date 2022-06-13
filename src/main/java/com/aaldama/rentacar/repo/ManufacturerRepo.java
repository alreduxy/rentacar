package com.aaldama.rentacar.repo;

import com.aaldama.rentacar.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ManufacturerRepo extends JpaRepository<Manufacturer, Integer> {

    @Query("SELECT m FROM Manufacturer m WHERE m.name LIKE %?1%")
    public List<Manufacturer> findByName(String brand);


}
