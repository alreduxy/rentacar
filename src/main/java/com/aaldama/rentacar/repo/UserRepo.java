package com.aaldama.rentacar.repo;

import com.aaldama.rentacar.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    public User findByUsername(String username);



}
