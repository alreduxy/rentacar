package com.aaldama.rentacar.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1105895467290051033L;

    private String username;
    private String fullName;
    private String email;
    private String phone;
    private String createAt;


}
