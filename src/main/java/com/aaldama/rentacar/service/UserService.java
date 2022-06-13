package com.aaldama.rentacar.service;


import com.aaldama.rentacar.model.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();
    public User findById(Long id);

    public User save(User user);
    public User update(User user);

    void deleteById(Long id);
}
