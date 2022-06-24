package com.aaldama.rentacar.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class VehicleRentalDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 2722897638402547421L;

    private Integer idVehicleRental;
    private String fullName;
    private String email;
    private String phone;
    private String locationName;
    private String vehicleTypeDescription;
    private String modelName;
    private Long dailyHireRate;
    private String manufacturerName;
    private Integer currentKilometers;
    private String plate;
    private String color;
    private String dateFrom;
    private String dateTo;
    private Integer quantityDays;
    private Integer totalPrice;

}

