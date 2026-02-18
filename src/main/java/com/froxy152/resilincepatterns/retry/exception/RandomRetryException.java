package com.froxy152.resilincepatterns.retry.exception;

public class RandomRetryException extends RuntimeException {
    public RandomRetryException(String message) {
        super(message);
    }
}
