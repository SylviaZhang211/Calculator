package org.example.calculator.exceptions;


/**
 * Exception thrown when an unsupported operation is requested.
 */
public class UnsupportedOperationException extends RuntimeException {

    public UnsupportedOperationException(String message) {
        super(message);
    }

    public UnsupportedOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
