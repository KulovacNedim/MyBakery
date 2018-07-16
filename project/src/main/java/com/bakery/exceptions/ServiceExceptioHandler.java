package com.bakery.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Logger;

@ControllerAdvice
public class ServiceExceptioHandler {

    Logger logger = Logger.getLogger(getClass().getName());

    @ExceptionHandler(ServiceException.class)
    public String handle(ServiceException ex) {
        handleLogger(ex);
        return "redirect:/error2";
    }

    public void handleLogger(ServiceException e) {
        logger.warning("Exception thrown ServiceException");
        logger.warning(" - ErrorCode: " + e.getErrorCode().getCode());
        logger.warning(" - Message: " + e.getErrorCode().getMessage());
    }

}
