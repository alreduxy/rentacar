package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.model.Menu;
import com.aaldama.rentacar.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private MenuService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Menu>> listar() {
        List<Menu> menues = new ArrayList<>();
        menues = service.findAll();
        return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Menu>> listar(@RequestBody String name) {
        List<Menu> menus = new ArrayList<>();
        menus = service.listarMenuPorUsuario(name);
        return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
    }

}
