package siemens.booking.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import siemens.booking.exceptions.NotFoundException;
import siemens.booking.exceptions.PreconditionFailedException;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleException(NotFoundException notFoundException){
        return new ResponseEntity<>(notFoundException.getMessage(), HttpStatusCode.valueOf(404));
    }
    @ExceptionHandler(PreconditionFailedException.class)
    public ResponseEntity<String> handleException(PreconditionFailedException preconditionFailedException){
        return new ResponseEntity<>(preconditionFailedException.getMessage(), HttpStatusCode.valueOf(412));
    }
}
