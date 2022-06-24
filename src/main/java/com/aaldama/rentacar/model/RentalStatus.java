package com.aaldama.rentacar.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "rental_status")
@DynamicUpdate
public class RentalStatus implements Serializable {

    public static final int AVAILABLE = 1;
    public static final int NOT_AVAILABLE = 2;
    public static final int IN_MANTEINANCE = 3;

    @Serial
    private static final long serialVersionUID = -2056024356819560776L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_status_id")
    private Integer idRentalStatus;

    @NotNull
    @Column(name = "rental_status_desc")
    private String name;

}
