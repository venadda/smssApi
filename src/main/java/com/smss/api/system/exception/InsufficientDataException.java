package com.smss.api.system.exception;

import java.sql.SQLException;

public class InsufficientDataException extends SQLException {
    private final String message;

    public InsufficientDataException() {
        super("Insufficient Details");
        this.message = "Insufficient Details";

    }
    public InsufficientDataException(String message) {
        super("Insufficient Details");
        this.message = message;

    }
    @Override
    public String getMessage() {
        return message;
    }
}
