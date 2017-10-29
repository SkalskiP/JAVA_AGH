package com.piotrskalski;

public class InvalidMethodArgumentsException extends Exception {

    InvalidMethodArgumentsException() {

    }

    InvalidMethodArgumentsException(String message) {
        super(message);
    }
}
