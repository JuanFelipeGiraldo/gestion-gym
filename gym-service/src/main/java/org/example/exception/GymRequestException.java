package org.example.exception;

public class GymRequestException extends Exception{

    private GymDetailsException detailsException;

    public GymRequestException(String message, GymDetailsException detailsException, Throwable e) {
        super(message, e);
        setDetailsException(detailsException);
    }

    public GymRequestException(String message, GymDetailsException detailsException){
        super(message);
        setDetailsException(detailsException);
    }

    public GymDetailsException getDetailsException() {
        return detailsException;
    }

    public void setDetailsException(GymDetailsException detailsException) {
        this.detailsException = detailsException;
    }
}
