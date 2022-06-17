package com.aaldama.rentacar.service;

import com.aaldama.rentacar.model.ResetToken;

public interface ResetTokenService {

    ResetToken findByToken(String token);
    void guardar(ResetToken token);
    void eliminar(ResetToken token);
}
