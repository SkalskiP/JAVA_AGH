package com.piotrskalski;

public class GivenFolderDoesNotExistException extends Exception {

    GivenFolderDoesNotExistException() {

    }

    GivenFolderDoesNotExistException(String message) {
        super(message);
    }
}
