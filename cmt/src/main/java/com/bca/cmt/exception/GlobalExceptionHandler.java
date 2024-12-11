package com.bca.cmt.exception;

import com.bca.cmt.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorResponseDto>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ErrorResponseDto> errors = ex.getBindingResult().getAllErrors().stream()
                .map(error -> new ErrorResponseDto(
                        ((FieldError) error).getField(),
                        error.getDefaultMessage()
                ))
                .toList();
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
