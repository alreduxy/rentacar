package com.aaldama.rentacar.repo;

import com.aaldama.rentacar.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    public User findByUsername(String username);
    Optional<User> findByEmail (String email);

    @Query(value = "SELECT " + "US.USERNAME," + "CONCAT(US.FIRST_NAME, ' ', US.LAST_NAME) AS FULL_NAME, " +
            "US.EMAIL, " + "US.PHONE, " + "US.CREATE_AT " +
            "FROM USERS US WHERE US.USER_ID = :idUser ORDER BY US.USER_ID", nativeQuery = true)
    public List<Object[]> listUserById(@Param("idUser") int idUser);


}
