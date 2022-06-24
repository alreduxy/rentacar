package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.model.Menu;
import com.aaldama.rentacar.repo.MenuRepo;
import com.aaldama.rentacar.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepo menuRepo;

    @Override
    public List<Menu> listarMenuPorUsuario(String nombre) {
        List<Menu> menus = new ArrayList<>();
        menuRepo.listarMenuPorUsuario(nombre).forEach(x -> {
            Menu m = new Menu();
            m.setIdMenu((Integer.parseInt(String.valueOf(x[0]))));
            m.setIcon(String.valueOf(x[1]));
            m.setName(String.valueOf(x[2]));
            m.setUrl(String.valueOf(x[3]));

            menus.add(m);
        });
        return menus;
    }

    @Override
    public Optional<Menu> findById(Integer id) throws Exception {
        Optional<Menu> op = menuRepo.findById(id);
        return Optional.of(op.orElseGet(Menu::new));
    }

    @Override
    public List<Menu> findAll() {
        return menuRepo.findAll();
    }

    @Override
    public Menu save(Menu menu) {
        return menuRepo.save(menu);
    }

    @Override
    public Menu update(Menu menu) {
        return menuRepo.save(menu);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        menuRepo.deleteById(id);
    }
}