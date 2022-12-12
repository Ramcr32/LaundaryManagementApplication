package com.laundaryApplication.LaundaryManagingApplication.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){

    }
    public NotFoundException(String message){
        super(message);
    }
}
