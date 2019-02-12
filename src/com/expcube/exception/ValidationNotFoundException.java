package com.expcube.exception;

public class ValidationNotFoundException extends RuntimeException {

    public ValidationNotFoundException(Exception e) {
        super(e);
    }

}
