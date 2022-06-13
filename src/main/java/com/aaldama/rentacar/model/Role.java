package com.aaldama.rentacar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role implements Serializable {

    @Serial
    private static final long serialVersionUID = -7581812154665249935L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private Long id;

    @Column(unique = true, length = 20)
    private String name;
}
