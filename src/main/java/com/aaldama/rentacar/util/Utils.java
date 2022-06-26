package com.aaldama.rentacar.util;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.ValidatorFactory;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Utils {

    public static String validarModelos(Object obj) throws ValidationException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<Object>> violations = factory.getValidator().validate(obj);
        String resultado = "";
        for (ConstraintViolation<Object> violation : violations) {
            resultado = resultado.concat(violation.getMessage()).concat("\n");
        }
        return resultado;
    }

    public static String encriptarClave(String clave) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(clave);
    }

    public static Long getQuantityDays(LocalDate as, LocalDate we) {
        return  ChronoUnit.DAYS.between(as, we);
    }

    public static Long getTotalPrice(Long days, Long price) {
        return days * price;
    }
}