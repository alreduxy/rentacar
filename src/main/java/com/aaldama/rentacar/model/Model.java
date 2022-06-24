package com.aaldama.rentacar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private Integer idModel;

    @NotNull
    @Column(name = "model_name")
    private String modelName;

    @JsonIgnoreProperties(value={"manufacturer", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @ManyToOne
    @JoinColumn(name="manufacturer_id", nullable=false, foreignKey = @ForeignKey(name = "fk_manufacturer_id"))
    private Manufacturer manufacturer;
}
