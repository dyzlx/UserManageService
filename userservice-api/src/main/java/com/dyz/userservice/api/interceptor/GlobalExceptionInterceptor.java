package com.dyz.userservice.api.interceptor;


import com.dyz.userservice.api.model.Result;
import com.dyz.userservice.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionInterceptor {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<Result> handlerBusinessException(BusinessException exception) {
        log.error("userservice catch business exception", exception);
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(Result.builder().code(exception.getCode()).message(exception.getMessage()).build());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Result> handlerModelValidException(MethodArgumentNotValidException exception) {
        log.error("userservice catch valid exception", exception);
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(Result.builder().code(0).message(exception.getBindingResult().getFieldError().getDefaultMessage()).build());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Result> handlerException(Exception exception) {
        log.error("userservice catch undefined exception", exception);
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Result.builder().code(-1).message(exception.getMessage()).build());
    }
}
