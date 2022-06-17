package com.aaldama.rentacar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "menu")
public class Menu implements Serializable {

    @Serial
    private static final long serialVersionUID = 8720971067121543406L;

    @Id
    @Column(name = "menu_id")
    private Integer id;

    @Column(length = 20)
    private String name;

    @Column(length = 50)
    private String url;

    @Column(length = 20)
    private String icon;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "menu_rol"
            , joinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "menu_id")
            , inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "rol_id"))
    private List<Role> roles;
}

