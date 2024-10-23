package hello.itemservice.web;

import hello.itemservice.web.validation.form.ResponseErr;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseErr> handleAllExceptions(Exception ex) {

        ResponseErr responseErr = new ResponseErr(ex.getMessage(),"ERR001");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(responseErr);
    }
}
