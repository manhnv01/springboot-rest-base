package io.github.manhnv01.springbootrestbase.exceptions;

import io.github.manhnv01.springbootrestbase.common.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> globalExceptionHandler(
            Exception ex, WebRequest request) {

        String path = (request instanceof ServletWebRequest swr)
                ? swr.getRequest().getServletPath()
                : Constant.UNKNOWN;

        if (ex instanceof BusinessException businessException) {
            ExceptionResponse body = new ExceptionResponse(
                    businessException.status,
                    new Date(),
                    businessException.getMessage(),
                    businessException.messageCode,
                    businessException.getMessage(),
                    path
            );
            return new ResponseEntity<>(body, businessException.status);
        }

        ExceptionResponse body = new ExceptionResponse(
                INTERNAL_SERVER_ERROR,
                new Date(),
                ExceptionMessage.INTERNAL_SERVER_ERROR.val,
                ex.getMessage(),
                path
        );
        return new ResponseEntity<>(body, INTERNAL_SERVER_ERROR);
    }
}
