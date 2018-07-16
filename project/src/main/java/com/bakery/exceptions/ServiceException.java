package com.bakery.exceptions;

import java.util.logging.Logger;

/**
 * The ServiceException wraps all checked standard Java exceptions.
 * Custom ErrorCode is added.
 */

public class ServiceException extends RuntimeException {

    private final ErrorCode errorCode;

    public ServiceException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ServiceException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ServiceException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void logErrorCode(){
        Logger logger = Logger.getLogger(getClass().getName());
        logger.info("Error code: " + this.errorCode.getCode() + ", Message: " + this.errorCode.getMessage());
    }
}
