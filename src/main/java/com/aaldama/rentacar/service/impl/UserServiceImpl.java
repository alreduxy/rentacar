package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.dto.UserDTO;
import com.aaldama.rentacar.model.User;
import com.aaldama.rentacar.repo.RoleRepo;
import com.aaldama.rentacar.repo.UserRepo;
import com.aaldama.rentacar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;


    @Override
    public List<User> findAll() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User update(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<UserDTO> listUserByUserId(int idUser) {
        List<UserDTO> listById = new ArrayList<>();
        userRepo.listUserById(idUser).forEach(u -> {
            UserDTO us = new UserDTO();
            us.setUsername(String.valueOf(u[0]));
            us.setFullName(String.valueOf(u[1]));
            us.setEmail(String.valueOf(u[2]));
            us.setPhone(String.valueOf(u[3]));
            us.setCreateAt(String.valueOf(u[4]));

            listById.add(us);
        });
        return listById;
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(String.format("El usuario no existe", username));
        }
        List<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        /*roles = new ArrayList<>();
        user.getRoles().forEach(rol -> {
        roles.add(new SimpleGrantedAuthority(rol.getName()));
        });*/

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getIsEnabled(),
                true,
                true,
                true,
        authorities);

    }
}

