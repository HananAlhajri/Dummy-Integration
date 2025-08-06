package com.coop.vrc.exception;

import com.coop.vrc.model.util.APIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected final ResponseEntity<?> handleGenericException(Exception exception) {
        log.error("Internal server error: {}", exception.getMessage(), exception);
        return APIResponse.fail(
                HttpStatus.INTERNAL_SERVER_ERROR,
                Collections.singletonList("An unexpected error occurred. Please try again later")
        );
    }

    @ExceptionHandler(NoSuchElementException.class)
    protected final ResponseEntity<?> handleNotFound() {
        return APIResponse.fail(
                HttpStatus.NOT_FOUND,
                Collections.singletonList("Vehicle not found")
        );
    }

    @Override
    protected @NonNull ResponseEntity<Object> handleMethodArgumentNotValid(@NonNull MethodArgumentNotValidException ex,
                                                                           @NonNull HttpHeaders headers,
                                                                           @NonNull HttpStatusCode status,
                                                                           @NonNull WebRequest request) {
        List<String> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        log.error("handleMethodArgumentNotValid:: {}", errors);
        return APIResponse.fail(HttpStatus.BAD_REQUEST, errors);
    }

}
