package com.aaldama.rentacar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "models")
public class Model implements Serializable {

    @Serial
    private static final long serialVersionUID = 6439016542109802512L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Integer id;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "daily_price")
    private Long dailyHireRate;

    @ManyToOne
    @JoinColumn(name="manufacturer_id", nullable=false, foreignKey = @ForeignKey(name = "fk_manufacturer_id"))
    private Manufacturer manufacturer;
}
