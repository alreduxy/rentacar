package com.aaldama.rentacar.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "locations")
@ApiModel(description = "Information about the location")
public class Location implements Serializable {

    @Serial
    private static final long serialVersionUID = 8129517512874481169L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Autoincrement id of the location")
    @Column(name = "location_id")
    private Integer idLocation;

    @NotNull
    @ApiModelProperty(notes = "Zip code number", example = "8320000")
    @Column(name = "location_zip_code")
    private Integer locationCode;

    @NotNull
    @ApiModelProperty(notes = "Location name", example = "Valdivia")
    @Size(min = 3, max = 50, message = "The location name must be max 50 characters")
    @Column(name = "location_name")
    private String locationName;
}
