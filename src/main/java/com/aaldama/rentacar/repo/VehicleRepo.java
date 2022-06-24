package com.aaldama.rentacar.repo;

import com.aaldama.rentacar.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Vehicle v SET v.rentalStatus = :rentalStatus WHERE v.idVehicle = :idVehicle")
    public void cambiarEstadoVehiculo(@Param("idVehicle") Integer idVehicle, @Param("rentalStatus") Integer rentalStatus) throws Exception;


    public Vehicle findByIdVehicle(Integer idUsuario);
//    @Transactional
//    @Modifying
//    @Query("UPDATE Vehicle v SET v.rentalStatus = :name WHERE v.idVehicle = :idVehicle")
//    public void cambiarEstadoVehiculo(@Param("idVehicle") Integer idVehicle, @Param("rentalStatus") Integer rentalStatus) throws Exception;
//

}
