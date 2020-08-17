package com.trust.samarthanam.DigitalLibrary.Exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message){
        super(message);
    }

}
