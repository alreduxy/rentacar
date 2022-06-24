package com.aaldama.rentacar.service;


import com.aaldama.rentacar.dto.UserDTO;
import com.aaldama.rentacar.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAll();
    public User findById(Integer id);
    public Optional<User> findByEmail(String email);
    public User save(User user);
    public User update(User user);
    List<UserDTO> listUserByUserId(int idUser);

    void deleteById(Integer id);
}
