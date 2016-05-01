package org.digitalpanda.springlab.web.controller;

import org.digitalpanda.springlab.spittr.DuplicateSpittleException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//application-wide exception handler
@ControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleDuplicateSpittle() {
        return "errors/duplicateSpittle";
    }
}
