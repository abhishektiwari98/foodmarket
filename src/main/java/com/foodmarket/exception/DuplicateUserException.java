package com.foodmarket.exception;

/**
 * Exception to represent a duplicate user registration failure.
 */
public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException() {
    }

    public DuplicateUserException(String message) {
        super(message);
    }
}
