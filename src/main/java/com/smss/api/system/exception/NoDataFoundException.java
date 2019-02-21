package com.smss.api.system.exception;

import org.springframework.http.HttpHeaders;

import javax.servlet.ServletException;
import java.sql.SQLException;

public class NoDataFoundException extends SQLException {
    private final String message;

    public NoDataFoundException() {
        super("No data found ");
        this.message = "No data found";

    }
    public NoDataFoundException(String message) {
        super("No data found ");
        this.message = message;

    }
    @Override
    public String getMessage() {
        return message;
    }
}
