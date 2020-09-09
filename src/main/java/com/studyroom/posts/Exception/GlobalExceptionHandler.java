package com.studyroom.posts.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Collections;
import java.util.List;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class, BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> badRequestExceptionHandle(Exception exception,
                                                                   WebRequest request) {
        return handleException(exception);
    }

    private ResponseEntity<ErrorResponse> handleException(Exception exception) {
        List<String> errorMessages = Collections.singletonList(exception.getMessage());
        String response = String.join(",", errorMessages);
        return new ResponseEntity<>(ErrorResponse.builder().status("failure").reason(response).build(), HttpStatus.BAD_REQUEST);
    }


}
