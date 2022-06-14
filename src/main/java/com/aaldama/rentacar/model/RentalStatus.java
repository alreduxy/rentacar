package com.aaldama.rentacar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "rental_status")
public class RentalStatus implements Serializable {

    @Serial
    private static final long serialVersionUID = -2056024356819560776L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_status")
    private Integer id;

    @NotNull
    @Column(name = "rental_status_desc")
    private String rentalStatusDescription;

}
