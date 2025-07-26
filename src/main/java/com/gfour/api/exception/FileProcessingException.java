package com.gfour.api.exception;

public class FileProcessingException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public FileProcessingException() {
        super();
    }

    public FileProcessingException(String message) {
        super(message);
    }

    public FileProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileProcessingException(Throwable cause) {
        super(cause);
    }

    protected FileProcessingException(String message, Throwable cause, 
                                   boolean enableSuppression, 
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
