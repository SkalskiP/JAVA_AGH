package com.piotrskalski;

public class NegativeFrameTimeException extends Exception{

    NegativeFrameTimeException() {

    }

    NegativeFrameTimeException(String message) {
        super(message);
    }
}
