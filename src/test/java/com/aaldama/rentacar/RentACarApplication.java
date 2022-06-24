package com.aaldama.rentacar;

import com.aaldama.rentacar.model.VehicleRental;
import net.minidev.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@Configuration
public class RentACarApplication{

//    @Autowired
//    private BCryptPasswordEncoder bcrypt;


    public static void main(String[] args) {
        SpringApplication.run(RentACarApplication.class, args);
    }

    //constraseña a modo de prueba para el usuario admin
//    @Override
//    public void run(String... args) throws Exception {
//        String password = "123456";
//        for (int i = 0; i < 4; i++) {
//            String passwordEncoded = bcrypt.encode(password);
//            System.out.println(bcrypt.encode(password));
//        }
//    }

}
