package com.aaldama.rentacar.repo;

import com.aaldama.rentacar.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LocationRepo extends JpaRepository<Location, Integer> {

}


