package com.exceptions;

public class InvalidClassInputException extends RuntimeException{
    InvalidClassInputException(String msg){
        super(msg);
    }
}
