package com.aaldama.rentacar.repo;

import com.aaldama.rentacar.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepo extends JpaRepository<Model, Integer> {


}
