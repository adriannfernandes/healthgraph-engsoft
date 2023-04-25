package com.engsoftware.heathgraph.service.exceptions;

public class ObjectAlreadyExistException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ObjectAlreadyExistException(String message) {
        super(message);
    }
}
