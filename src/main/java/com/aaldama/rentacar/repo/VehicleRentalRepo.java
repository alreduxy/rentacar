package com.aaldama.rentacar.repo;

import com.aaldama.rentacar.model.VehicleRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRentalRepo extends JpaRepository<VehicleRental, Integer> {

    @Query(value = "SELECT " + "CONCAT(CU.FIRST_NAME, ' ', CU.LAST_NAME) AS FULL_NAME, " +
            "CU.EMAIL, " + "L.LOCATION_NAME, " + "TY.VEHICLE_TYPE_DESC, " +
            "M.MODEL_NAME, " + "M.DAILY_PRICE, " + "MA.MANUFACTURER_NAME, " +
            "V.CURRENT_KM, " + "VR.DATE_FROM, " + "VR.DATE_TO, " +
            "CAST(EXTRACT(DAY FROM AGE(VR.DATE_TO, date(VR.DATE_FROM))) AS INTEGER) AS QUANTITY_DAYS, " +
            "CAST((EXTRACT(DAY FROM AGE(VR.DATE_TO, date(VR.DATE_FROM))) * M.DAILY_PRICE) AS BIGINT) AS TOTAL_PRICE " +
            "FROM CUSTOMERS CU inner join VEHICLE_RENTALS VR on VR.CUSTOMER_ID = CU.CUSTOMER_ID " +
            "inner join VEHICLES V on VR.VEHICLE_ID = V.VEHICLE_ID " +
            "inner join VEHICLE_TYPES TY on TY.VEHICLE_TYPE_ID = V.VEHICLE_TYPE_ID " +
            "inner join MODELS M on M.MODEL_ID = V.MODEL_ID " +
            "inner join MANUFACTURERS MA on MA.MANUFACTURER_ID = M.MANUFACTURER_ID " +
            "inner join LOCATIONS L on L.LOCATION_ID = V.LOCATION_ID ORDER BY VR.VEHICLE_RENTAL_ID",
            nativeQuery = true)

    public List<Object[]> listarVehiculosRentados();

    @Query(value = "SELECT " + "CONCAT(CU.FIRST_NAME, ' ', CU.LAST_NAME) AS FULL_NAME, " +
            "CU.EMAIL, " + "L.LOCATION_NAME, " + "TY.VEHICLE_TYPE_DESC, " +
            "M.MODEL_NAME, " + "M.DAILY_PRICE, " + "MA.MANUFACTURER_NAME, " +
            "V.CURRENT_KM, " + "VR.DATE_FROM, " + "VR.DATE_TO, " +
            "CAST(EXTRACT(DAY FROM AGE(VR.DATE_TO, date(VR.DATE_FROM))) AS INTEGER) AS QUANTITY_DAYS, " +
            "CAST((EXTRACT(DAY FROM AGE(VR.DATE_TO, date(VR.DATE_FROM))) * M.DAILY_PRICE) AS BIGINT) AS TOTAL_PRICE " +
            "FROM CUSTOMERS CU inner join VEHICLE_RENTALS VR on VR.CUSTOMER_ID = CU.CUSTOMER_ID " +
            "inner join VEHICLES V on VR.VEHICLE_ID = V.VEHICLE_ID " +
            "inner join VEHICLE_TYPES TY on TY.VEHICLE_TYPE_ID = V.VEHICLE_TYPE_ID " +
            "inner join MODELS M on M.MODEL_ID = V.MODEL_ID " +
            "inner join MANUFACTURERS MA on MA.MANUFACTURER_ID = M.MANUFACTURER_ID " +
            "inner join LOCATIONS L on L.LOCATION_ID = V.LOCATION_ID WHERE CU.CUSTOMER_ID = :customer_id ORDER BY VR.VEHICLE_RENTAL_ID",
            nativeQuery = true)

    public List<Object[]> listarVehiculosRentadosPorUsuario(@Param("customer_id") Long customer_id);
}
