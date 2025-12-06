package com.exceptions;

public class EmailTypeMissMatchException extends RuntimeException{
    EmailTypeMissMatchException(String msg){

        super(msg);
    }
}
