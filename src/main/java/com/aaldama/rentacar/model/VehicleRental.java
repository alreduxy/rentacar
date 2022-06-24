package com.aaldama.rentacar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;


@Getter
@Setter
@Entity
@Table(name = "vehicle_rentals")
public class VehicleRental implements Serializable {

    @Serial
    private static final long serialVersionUID = 3066059500583135982L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Integer idVehicleRental;

    @Column(name="date_from")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dateFrom;

    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(name = "date_to")
    private LocalDate dateTo;

    @Column(name = "total_price")
    private Long totalPrice;

    @Column(name = "quantity_days")
    private Long quantityDays;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user_id"))
    private User user;

    @JsonIgnoreProperties(value={"vehicle", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @ManyToOne
    @JoinColumn(name="vehicle_id", nullable=false, foreignKey = @ForeignKey(name = "fk_vehicle_id"))
    private Vehicle vehicle;





}
