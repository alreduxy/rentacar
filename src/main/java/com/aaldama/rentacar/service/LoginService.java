package com.aaldama.rentacar.service;

import com.aaldama.rentacar.model.User;

public interface LoginService {

    User verificarNombreUsuario(String usuario) throws Exception;
    int changePassword(String password, String nombre) throws Exception;
}
