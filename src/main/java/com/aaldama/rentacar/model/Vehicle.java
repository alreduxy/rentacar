package com.aaldama.rentacar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;


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
    private Integer idVehicle;

    @NotNull
    @Column(name = "current_km")
    private Integer currentKilometers;

//    @NotNull
//    @JsonFormat(pattern="dd-MM-yyyy")
//    @Temporal(TemporalType.DATE)
//    @Column(name = "due_date")
//    private Date dateMotDue;
//
//    @PrePersist
//    public void prePersist() { this.dateMotDue = new Date();
//    }

    @NotNull
    @Column(name = "daily_price")
    private Long dailyHireRate;

    @NotNull
    @Column(name = "plate_number")
    private String plate;

    @NotNull
    @Column(name = "color")
    private String color;

    @NotNull
    @Column(name = "full_tank")
    private Boolean fullTank;

    @Column(name = "vehicle_stock")
    private Integer stock;


    @ManyToOne
    @JoinColumn(name="rental_status_id", nullable=false, foreignKey = @ForeignKey(name = "fk_rental_status_id"))
    private RentalStatus rentalStatus;

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
