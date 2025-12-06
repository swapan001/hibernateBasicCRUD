package com.exceptions;

public class InvalidGenderInputException extends RuntimeException{
    InvalidGenderInputException(String msg){
        super(msg);
    }
}
