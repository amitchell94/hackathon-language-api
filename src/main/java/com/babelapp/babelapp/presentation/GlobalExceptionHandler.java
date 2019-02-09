package com.babelapp.babelapp.presentation;

import com.babelapp.babelapp.logic.InvalidSourceLanguageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid Source Language")
    @ExceptionHandler(InvalidSourceLanguageException.class)
    public void handlesInvalidTokenException(HttpServletRequest request, Exception exception) {
        logger.info("Invalid Source Language Exception Occurred:: URL=" + request.getRequestURL());
        logger.info("the exception was : =" + exception.getMessage());
    }

}

