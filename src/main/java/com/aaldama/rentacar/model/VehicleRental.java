package com.aaldama.rentacar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
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
    @Column(name = "vehicle_rental_id")
    private Integer id;

    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(name = "date_from")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;

    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(name = "date_to")
    @Temporal(TemporalType.DATE)
    private Date dateTo;

    @PrePersist
    public void prePersist() {
        this.dateFrom = new Date();
        this.dateTo = new Date();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, foreignKey = @ForeignKey(name = "fk_vehicle_rental_customer"))
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="rental_status_id", nullable=false, foreignKey = @ForeignKey(name = "fk_rental_status_id"))
    private RentalStatus rentalStatus;

    @JsonIgnoreProperties(value={"vehicle", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @ManyToOne
    @JoinColumn(name="vehicle_id", nullable=false, foreignKey = @ForeignKey(name = "fk_vehicle_id"))
    private Vehicle vehicle;

    @Column(name = "quantity_days")
    private Integer quantityDays;

    public Integer getQuantityDays() {
        long diff = dateTo.getTime() - dateFrom.getTime();
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public Long getTotalPrice() {

        return getQuantityDays() * vehicle.getModel().getDailyHireRate();

    }



}
