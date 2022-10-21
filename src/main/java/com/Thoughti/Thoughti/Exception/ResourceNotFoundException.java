package com.Thoughti.Thoughti.Exception;

public class ResourceNotFoundException extends RuntimeException {
    int orderId;

    public ResourceNotFoundException(int orderId) {
        super(String.format(" %s not found",orderId));
        this.orderId = orderId;

    }
}
