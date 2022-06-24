package com.aaldama.rentacar.repo;

import com.aaldama.rentacar.model.RentalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalStatusRepo extends JpaRepository<RentalStatus, Integer> {



}

