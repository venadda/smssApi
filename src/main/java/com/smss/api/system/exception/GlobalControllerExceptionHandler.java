package com.smss.api.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;

public class GlobalControllerExceptionHandler {
    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse constraintViolationException(ConstraintViolationException ex) {
        ErrorResponse response = new ErrorResponse.ErrorResponseBuilder()
                .withStatus(HttpStatus.BAD_REQUEST)
                .withError_code(HttpStatus.BAD_REQUEST.name())
                .withMessage(ex.getLocalizedMessage()).build();


        return response;
    }

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse noHandlerFoundException(Exception ex) {
        ErrorResponse response = new ErrorResponse.ErrorResponseBuilder()
                .withStatus(HttpStatus.NOT_FOUND)
                .withError_code(HttpStatus.BAD_REQUEST.name())
                .withMessage(ex.getLocalizedMessage()).build();


        return response;

    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse unknownException(Exception ex) {
        ErrorResponse response = new ErrorResponse.ErrorResponseBuilder()
                .withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .withError_code(HttpStatus.BAD_REQUEST.name())
                .withMessage(ex.getLocalizedMessage()).build();


        return response;

    }
    @ExceptionHandler(value={NoDataFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse noDataFoundException(Exception ex){
        ErrorResponse response = new ErrorResponse.ErrorResponseBuilder()
                .withStatus(HttpStatus.NOT_FOUND)
                .withError_code(HttpStatus.NOT_FOUND.name())
                .withMessage(ex.getMessage()).build();
        return response;
    }


}
