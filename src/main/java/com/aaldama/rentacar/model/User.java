package com.aaldama.rentacar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 4527422709586236953L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true, length = 20)
    private String username;

    @Column(length = 60)
    private String password;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "id_card", unique = true)
    @Size(min = 9, max = 10)
    private String idCard;

    @Column(unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns= @JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="role_id"),
            uniqueConstraints= {@UniqueConstraint(columnNames= {"user_id", "role_id"})})
    private List<Role> roles;

}
