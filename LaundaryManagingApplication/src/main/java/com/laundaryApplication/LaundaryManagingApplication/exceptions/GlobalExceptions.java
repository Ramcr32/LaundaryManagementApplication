package com.laundaryApplication.LaundaryManagingApplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MyErrorDetails> myExpHandler1(NotFoundException ie,WebRequest wr)
    {
        MyErrorDetails err= new MyErrorDetails(LocalDateTime.now(),ie.getMessage(),wr.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> myExpHandler3(MethodArgumentNotValidException me) {
        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),"Handler Exceptions",me.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> myExpHandler(Exception e, WebRequest wr)
    {
        MyErrorDetails err= new MyErrorDetails( LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(IllegalArgumentException.class)
    public  ResponseEntity<MyErrorDetails> myErrorHandler(IllegalArgumentException e, WebRequest wr){
        MyErrorDetails err= new MyErrorDetails( LocalDateTime.now(),e.getMessage(),wr.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

}
