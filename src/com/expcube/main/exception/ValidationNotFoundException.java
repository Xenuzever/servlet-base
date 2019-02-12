package com.expcube.main.exception;

public class ValidationNotFoundException extends RuntimeException {

    public ValidationNotFoundException(Exception e) {
        super(e);
    }

}
