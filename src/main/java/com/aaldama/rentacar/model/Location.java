package com.aaldama.rentacar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "locations")
public class Location implements Serializable {

    @Serial
    private static final long serialVersionUID = 8129517512874481169L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Integer id;

    @NotNull
    @Column(name = "location_zip_code")
    private Integer locationCode;

    @NotNull
    @Column(name = "location_name")
    private String locationName;
}
