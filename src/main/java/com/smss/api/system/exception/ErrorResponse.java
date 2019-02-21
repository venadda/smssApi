package com.smss.api.system.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
// 4xx -> client errors
//5xx -> server errors
public class ErrorResponse {
    private HttpStatus status;
    private String error_code;
    private String message;
    private String detail;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;


    public static final class ErrorResponseBuilder {
        private HttpStatus status;
        private String error_code;
        private String message;
        private String detail;

        public ErrorResponseBuilder() {
        }

        public static ErrorResponseBuilder anErrorResponse() {
            return new ErrorResponseBuilder();
        }

        public ErrorResponseBuilder withStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ErrorResponseBuilder withError_code(String error_code) {
            this.error_code = error_code;
            return this;
        }

        public ErrorResponseBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ErrorResponseBuilder withDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public ErrorResponse build() {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.status = this.status;
            errorResponse.error_code = this.error_code;
            errorResponse.detail = this.detail;
            errorResponse.message = this.message;
            errorResponse.timestamp = LocalDateTime.now();
            return errorResponse;
        }
    }
}
