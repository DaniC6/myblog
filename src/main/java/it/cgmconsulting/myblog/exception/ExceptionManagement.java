package it.cgmconsulting.myblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ExceptionManagement {

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<?> methodArgumentTypeMismatchException (MethodArgumentTypeMismatchException ex) {
       return new ResponseEntity<String> ( ex.getMessage (), HttpStatus.BAD_REQUEST );
    }

}
