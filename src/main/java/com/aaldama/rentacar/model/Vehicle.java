package com.aaldama.rentacar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "vehicles")
public class Vehicle implements Serializable {

    @Serial
    private static final long serialVersionUID = 6468916134190235320L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Integer id;

    @Column(name = "current_km")
    private Integer currentKilometers;

    @JsonFormat(pattern="dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "due_date")
    private Date dateMotDue;

    @Column(name = "full_tank")
    private Boolean fullTank;

    @PrePersist
    public void prePersist() { this.dateMotDue = new Date();
    }

    @Column(name = "engine_size")
    private Double engineSize;

    @ManyToOne
    @JoinColumn(name="location_id", nullable=false, foreignKey = @ForeignKey(name = "fk_location_id"))
    private Location location;

    @ManyToOne
    @JoinColumn(name="model_id", nullable=false, foreignKey = @ForeignKey(name = "fk_model_id"))
    private Model model;

    @ManyToOne
    @JoinColumn(name="vehicle_type_id", nullable=false, foreignKey = @ForeignKey(name = "fk_vehicle_type_id"))
    private VehicleType vehicleType;

}
