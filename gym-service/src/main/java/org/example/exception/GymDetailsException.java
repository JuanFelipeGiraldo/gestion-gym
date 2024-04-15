package org.example.exception;

import org.springframework.http.HttpStatus;

public class GymDetailsException {

    private String message;
    private HttpStatus httpStatus;

    public GymDetailsException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void getHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
