package ru.kudinov.electrictrainscontroll.advice;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.kudinov.electrictrainscontroll.dto.ExceptionResponse;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ExceptionResponse handleBusinessException(EntityNotFoundException ex) {
        return new ExceptionResponse(ex);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(EntityExistsException.class)
    public ExceptionResponse handleBusinessException(EntityExistsException ex) {
        return new ExceptionResponse(ex);
    }
}
