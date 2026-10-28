package com.example.cruddto.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message)
    {
        super(message);
    }

}
