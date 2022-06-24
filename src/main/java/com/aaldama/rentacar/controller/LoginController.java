package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.model.ResetToken;
import com.aaldama.rentacar.model.User;
import com.aaldama.rentacar.service.LoginService;
import com.aaldama.rentacar.service.ResetTokenService;
import com.aaldama.rentacar.util.EmailUtil;
import com.aaldama.rentacar.util.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @Autowired
    private ResetTokenService tokenService;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @PostMapping(value = "/enviar-correo", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Integer> enviarCorreo(@RequestBody String correo) {
        int rpta = 0;
        try {
            User us = service.verificarNombreUsuario(correo);
            if (us != null && us.getIdUser() > 0) {

                ResetToken token = new ResetToken();
                token.setToken(UUID.randomUUID().toString());
                token.setUser(us);
                token.setExpiryDate(10);
                tokenService.guardar(token);

                Mail mail = new Mail();
                mail.setFrom("let.aldama@gmail.com");
                mail.setTo(us.getEmail());
                mail.setSubject("RESTABLECER CONTRASEÑA - RENTACAR");

                Map<String, Object> model = new HashMap<>();
                String url = "http://localhost:4200/recuperar/" + token.getToken();
                model.put("user", us.getFirstName() + " " + us.getLastName());
                model.put("resetUrl", url);
                mail.setModel(model);
                emailUtil.enviarMail(mail);
                rpta = 1;
            }
        } catch(Exception e) {
            return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
    }

    @GetMapping(value = "/restablecer/verificar/{token}")
    public ResponseEntity<Integer> restablecerClave(@PathVariable("token") String token) {
        int rpta = 0;
        try {
            if (token != null && !token.isEmpty()) {
                ResetToken rt = tokenService.findByToken(token);
                if (rt != null && rt.getIdResetToken() > 0) {
                    if (!rt.isExpiryDate()) {
                        rpta = 1;
                    }
                }
            }
        } catch (Exception e) {
            return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
    }

    @PostMapping(value = "/restablecer/{token}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> restablecerClave(@PathVariable("token") String token, @RequestBody String clave ) {
        int rpta = 0;
        try {
            ResetToken rt = tokenService.findByToken(token);
            String claveHash = bcrypt.encode(clave);
            rpta = service.changePassword(claveHash, rt.getUser().getFirstName());
            tokenService.eliminar(rt);
        } catch (Exception e) {
            return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
    }
}
