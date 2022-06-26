package com.aaldama.rentacar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

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
