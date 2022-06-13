package com.aaldama.rentacar.exception;

import java.io.Serial;

public class ModeloNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -594996173174318021L;

    public ModeloNotFoundException(String message) {
        super(message);
    }
}



