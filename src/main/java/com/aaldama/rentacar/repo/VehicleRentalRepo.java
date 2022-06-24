package com.aaldama.rentacar.repo;

import com.aaldama.rentacar.model.VehicleRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface VehicleRentalRepo extends JpaRepository<VehicleRental, Integer> {

    @Query(value = "SELECT " + "CONCAT(US.FIRST_NAME, ' ', US.LAST_NAME) AS FULL_NAME, " +
            "US.EMAIL, " + "US.PHONE, " +
            "L.LOCATION_NAME, " +
            "TY.VEHICLE_TYPE_DESC, " +
            "M.MODEL_NAME, " + "V.DAILY_PRICE, " +
            "MA.MANUFACTURER_NAME, " +
            "V.CURRENT_KM, " + "V.PLATE_NUMBER," + "V.COLOR," +
            "VR.DATE_FROM, " + "VR.DATE_TO, " +
            "CAST(EXTRACT(DAY FROM AGE(VR.DATE_TO, date(VR.DATE_FROM))) AS INTEGER) AS QUANTITY_DAYS, " +
            "CAST((EXTRACT(DAY FROM AGE(VR.DATE_TO, date(VR.DATE_FROM))) * V.DAILY_PRICE) AS BIGINT) AS TOTAL_PRICE " +
            "FROM USERS US inner join VEHICLE_RENTALS VR on VR.USER_ID = US.USER_ID " +
            "inner join VEHICLES V on VR.VEHICLE_ID = V.VEHICLE_ID " +
            "inner join VEHICLE_TYPES TY on V.VEHICLE_TYPE_ID = TY.VEHICLE_TYPE_ID " +
            "inner join MODELS M on V.MODEL_ID = M.MODEL_ID " +
            "inner join MANUFACTURERS MA on M.MANUFACTURER_ID = MA.MANUFACTURER_ID " +
            "inner join LOCATIONS L on V.LOCATION_ID = L.LOCATION_ID WHERE US.USER_ID = :idUser ORDER BY VR.RENTAL_ID",
            nativeQuery = true)
    public List<Object[]> listVehicleByUserId(@Param("idUser") int idUser);

//    @Query(value = "SELECT " + "CONCAT(US.FIRST_NAME, ' ', US.LAST_NAME) AS FULL_NAME, " +
//            "US.EMAIL, " + "L.LOCATION_NAME, " + "TY.VEHICLE_TYPE_DESC, " +
//            "M.MODEL_NAME, " + "M.DAILY_PRICE, " + "MA.MANUFACTURER_NAME, " +
//            "V.CURRENT_KM, " + "V.PLATE_NUMBER," + "V.COLOR," + "VR.DATE_FROM, " + "VR.DATE_TO, " +
//            "CAST(EXTRACT(DAY FROM AGE(VR.DATE_TO, date(VR.DATE_FROM))) AS INTEGER) AS QUANTITY_DAYS, " +
//            "CAST((EXTRACT(DAY FROM AGE(VR.DATE_TO, date(VR.DATE_FROM))) * M.DAILY_PRICE) AS BIGINT) AS TOTAL_PRICE " +
//            "FROM USERS US inner join VEHICLE_RENTALS VR on VR.USER_ID = US.USER_ID " +
//            "inner join VEHICLES V on VR.VEHICLE_ID = V.VEHICLE_ID " +
//            "inner join VEHICLE_TYPES TY on V.VEHICLE_TYPE_ID = TY.VEHICLE_TYPE_ID " +
//            "inner join MODELS M on V.MODEL_ID = M.MODEL_ID " +
//            "inner join MANUFACTURERS MA on M.MANUFACTURER_ID = MA.MANUFACTURER_ID " +
//            "inner join LOCATIONS L on V.LOCATION_ID = L.LOCATION_ID WHERE US.USER_ID = :idUser ORDER BY VR.RENTAL_ID",
//            nativeQuery = true)
//
//    public List<Object[]> listarVehiculosRentadosPorUsuario(@Param("idUser") Integer idUser);



}
