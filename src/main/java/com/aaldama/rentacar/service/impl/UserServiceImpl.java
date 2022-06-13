package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.model.User;
import com.aaldama.rentacar.repo.RoleRepo;
import com.aaldama.rentacar.repo.UserRepo;
import com.aaldama.rentacar.service.UserService;
import lombok.RequiredArgsConstructor;
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
    public User findById(Long id) {
        return userRepo.findById(id).orElse(null);
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
    public void deleteById(Long id) {
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
                user.getEnabled(),
                true,
                true,
                true,
        authorities);

    }
}

