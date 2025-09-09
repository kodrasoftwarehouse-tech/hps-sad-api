package com.hps.vilanova.exceptions;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {

    private final int statusCode;

    public ValidationException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

}
