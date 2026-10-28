package com.example.cruddto.exception;


import com.example.cruddto.dto.ExceptionResponseDto;
import com.example.cruddto.dto.VlidationExceptionResponsedto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ExceptionResponseDto> handleDuplicateResourceException(DuplicateResourceException ex, HttpServletRequest request)
    {
        ExceptionResponseDto exceptionResponse=new ExceptionResponseDto(
                ex.getMessage(),
                request.getRequestURI(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                HttpStatus.CONFLICT.value(),
                LocalDateTime.now()

        );
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exceptionResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<VlidationExceptionResponsedto> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex,HttpServletRequest request)
    {
        Map<String,String> fieldError=new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                        .forEach(error->fieldError.put(error.getField(),error.getDefaultMessage()));
        VlidationExceptionResponsedto exceptionResponse=new VlidationExceptionResponsedto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Validation Failed",
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                request.getRequestURI(),
                fieldError
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exceptionResponse);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleResourceNotFoundException(ResourceNotFoundException ex,HttpServletRequest request)
    {
        ExceptionResponseDto exceptionResponse=new ExceptionResponseDto(
                ex.getMessage(),
                request.getRequestURI(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()

        );
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionResponse);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDto> handleRuntimeException(RuntimeException ex,HttpServletRequest request)
    {

        ExceptionResponseDto exceptionResponse=new ExceptionResponseDto(
                ex.getMessage(),
                request.getRequestURI(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now()

        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponse);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleGenericException(Exception ex,HttpServletRequest request)
    {

        ExceptionResponseDto exceptionResponse=new ExceptionResponseDto(
                ex.getMessage(),
                request.getRequestURI(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now()

        );
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponse);
    }
}
