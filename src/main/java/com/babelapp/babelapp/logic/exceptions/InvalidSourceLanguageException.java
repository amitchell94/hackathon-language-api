package com.babelapp.babelapp.logic.exceptions;

public class InvalidSourceLanguageException extends RuntimeException {

    public InvalidSourceLanguageException() {
    }
    public InvalidSourceLanguageException(String message) {
        super(message);
    }

    public InvalidSourceLanguageException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSourceLanguageException(Throwable cause) {
        super(cause);
    }

    public InvalidSourceLanguageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
