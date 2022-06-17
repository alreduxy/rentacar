package com.aaldama.rentacar.repo;

import com.aaldama.rentacar.model.ResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResetTokenRepo extends JpaRepository<ResetToken, Integer> {

    ResetToken findByToken(String token);


}
