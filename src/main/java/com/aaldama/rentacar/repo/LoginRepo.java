package com.aaldama.rentacar.repo;


import com.aaldama.rentacar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LoginRepo extends JpaRepository<User, Integer> {

    @Query("FROM User u where u.username = :email")
    User verificarNombreUsuario(@Param("email") String nombre) throws Exception;

    //Usuario findOneByUsername(String usuario)

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.password = :clave WHERE u.username = :email")
    void changePassword(@Param("clave") String clave, @Param("email") String nombre) throws Exception;

}
