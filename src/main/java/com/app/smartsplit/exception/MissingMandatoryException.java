package com.app.smartsplit.exception;

public class MissingMandatoryException extends RuntimeException{

    public MissingMandatoryException(String msg){
        super(msg);
    }

}
