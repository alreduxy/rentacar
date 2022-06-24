package com.aaldama.rentacar.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "Information about the manufacturer")
public class Manufacturer implements Serializable {

    @Serial
    private static final long serialVersionUID = 8554585195392299400L;

    @Id
    @ApiModelProperty(notes = "Autoincrement id of the manufacturer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id")
    private Integer idManufacturer;

    @NotNull
    @ApiModelProperty(notes = "Manufacturer name", example = "Ford")
    @Column(name = "manufacturer_name")
    private String name;


}
