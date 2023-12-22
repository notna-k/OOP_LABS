package org.fpm.di;

public class CircularInjectException extends RuntimeException {
    public CircularInjectException(String message) {
        super(message);
    }
}
