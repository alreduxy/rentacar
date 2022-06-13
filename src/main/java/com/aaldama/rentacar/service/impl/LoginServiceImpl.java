package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.model.User;
import com.aaldama.rentacar.repo.LoginRepo;
import com.aaldama.rentacar.service.LoginService;
import com.aaldama.rentacar.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepo loginRepo;

    @Override
    public int changePassword(String clave, String nombre) {
        int result = 0;
        try {
            loginRepo.changePassword(Utils.encriptarClave(clave), nombre);
            result = 1;
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }

    @Override
    public User verificarNombreUsuario(String nombre) throws Exception {
        User user = null;
        try {
            user = loginRepo.verificarNombreUsuario(nombre);
            user = user != null ? user : new User();
        } catch (Exception e) {
            user = new User();
        }
        return user;
    }

}