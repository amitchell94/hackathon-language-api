package com.babelapp.babelapp.logic.exceptions;

public class TranslationErrorException extends RuntimeException {
    public TranslationErrorException() {
    }
    public TranslationErrorException(String message) {
        super(message);
    }

    public TranslationErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public TranslationErrorException(Throwable cause) {
        super(cause);
    }

    public TranslationErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
