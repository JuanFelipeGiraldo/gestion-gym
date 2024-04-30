package org.example.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GymExceptionHandler  {

    private static final Logger LOG = LoggerFactory.getLogger(GymExceptionHandler.class.getName());

    @ExceptionHandler(value = {GymRequestException.class})
    public ResponseEntity<GymDetailsException> handlerRequestExceptions(GymRequestException ex){
        LOG.error(ex.getMessage(), ex);
        return new ResponseEntity<>(ex.getDetailsException(), ex.getDetailsException().getHttpStatus());
    }

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public ResponseEntity<GymDetailsException> handlerRequestExceptions(Throwable ex){
        LOG.error(ex.getMessage(), ex);
        GymDetailsException detailsException = new GymDetailsException("Ha ocurrido un error inesperado.", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(detailsException, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Map<String, String> handlerValidateExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors().forEach( error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();

            errors.put(fieldName, message);
        });
        return errors;
    }

    @ExceptionHandler(value = {BadCredentialsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleInternalAuthenticationServiceException(BadCredentialsException ex) {
        return ResponseEntity.badRequest().body("Error de autenticación: " + ex.getMessage());
    }

}