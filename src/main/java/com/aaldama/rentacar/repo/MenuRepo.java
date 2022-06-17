package com.aaldama.rentacar.repo;

import com.aaldama.rentacar.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Integer> {

    @Query(value = "select m.* from menu_rol mr inner join users_roles ur on ur.rol_id = mr.rol_id inner join " +
            "menu m on m.menu_id = mr.menu_id inner join user u on u.user_id = ur.user_id where u.username = :username", nativeQuery = true)
    List<Object[]> listarMenuPorUsuario(@Param("username") String username);

}
