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
@Table(name = "manufacturers")
public class Manufacturer implements Serializable {

    @Serial
    private static final long serialVersionUID = 8554585195392299400L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id")
    private Integer id;

    @NotNull
    @Column(name = "manufacturer_name")
    private String name;


}
