package com.aaldama.rentacar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    @Serial
    private static final long serialVersionUID = -7270401741001555962L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @NotEmpty(message = "The name is required")
    @Size(min = 3, max = 25, message = "The name must be between 3 and 25 characters")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty(message = "The last name is required")
    @Size(min = 3, max = 25, message = "The last name must be between 3 and 25 characters")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotEmpty(message = "The email is required")
    @Email(message = "The email is not valid")
    @Column(name = "email", unique = true)
    private String email;

    @JsonFormat(pattern="dd-MM-yyyy")
    @NotNull(message = "It cant be empty")
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @JsonIgnoreProperties(value={"customer", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    private List<VehicleRental> vehicleRentals;

    public Customer() {
        this.vehicleRentals = new ArrayList<>();
    }

    @PrePersist
    public void prePersist() { this.createAt = new Date();}
}
