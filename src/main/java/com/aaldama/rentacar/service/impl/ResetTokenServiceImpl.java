package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.model.ResetToken;
import com.aaldama.rentacar.repo.ResetTokenRepo;
import com.aaldama.rentacar.service.ResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetTokenServiceImpl implements ResetTokenService {

    @Autowired
    private ResetTokenRepo repo;

    @Override
    public ResetToken findByToken(String token) {
        return repo.findByToken(token);
    }

    @Override
    public void guardar(ResetToken token) {
        repo.save(token);

    }

    @Override
    public void eliminar(ResetToken token) {
        repo.delete(token);
    }

}
