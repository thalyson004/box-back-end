package com.saper.boxbackend.exception;


import com.saper.boxbackend.dto.ErrorDTO;
import com.saper.boxbackend.exception.exceptions.ConflictStoreException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.*;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,
                                                        HttpServletRequest request
                                                        ) {
        List<ErrorDTO> errors = new ArrayList<>();
        exception
                .getBindingResult()
                .getAllErrors()
                .forEach(error -> {
                    errors.add(new ErrorDTO(
                            Instant.now(),
                            HttpStatus.BAD_REQUEST.toString(),
                            ((FieldError) error).getField(),
                            error.getDefaultMessage(),
                            request.getRequestURI()));
                });
        return errors;
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ErrorDTO handleNoSuchElementException(NoSuchElementException exception, HttpServletRequest request) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTimeStamp(Instant.now());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.toString());
        errorDTO.setError("resource not found");
        errorDTO.setMessage(exception.getMessage());
        errorDTO.setPath(request.getRequestURI());
        return errorDTO;
    }

    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ErrorDTO handleDataIntegrityViolationException(
            DataIntegrityViolationException exception,
            HttpServletRequest request) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTimeStamp(Instant.now());
        errorDTO.setStatus(HttpStatus.CONFLICT.toString());
        errorDTO.setError("Database conflict");
        errorDTO.setMessage("Could not execute statement");
        errorDTO.setPath(request.getRequestURI());
        return errorDTO;
    }

    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ExceptionHandler(ConflictStoreException.class)
    public ErrorDTO handleConflictStoreException(
            ConflictStoreException exception,
            HttpServletRequest request) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTimeStamp(Instant.now());
        errorDTO.setStatus(HttpStatus.CONFLICT.toString());
        errorDTO.setError("Database conflict");
        errorDTO.setMessage(exception.getMessage());
        errorDTO.setPath(request.getRequestURI());
        return errorDTO;
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    public ErrorDTO handleException(
            Exception exception,
            HttpServletRequest request) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTimeStamp(Instant.now());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.toString());
        errorDTO.setError("resource not found");
        errorDTO.setMessage(exception.getMessage());
        errorDTO.setPath(request.getRequestURI());
        return errorDTO;
    }
}

