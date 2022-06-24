package com.aaldama.rentacar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "vehicle_types")
public class VehicleType implements Serializable {

    @Serial
    private static final long serialVersionUID = 6156358325095190358L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_type_id")
    private Integer idVehicleType;

    @Column(name = "vehicle_type_desc")
    private String vehicleTypeDescription;
}
