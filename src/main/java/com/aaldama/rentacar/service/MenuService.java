package com.aaldama.rentacar.service;

import com.aaldama.rentacar.model.Menu;

import java.util.List;

public interface MenuService extends ICRUD<Menu> {
    List<Menu> listarMenuPorUsuario(String name);
}
