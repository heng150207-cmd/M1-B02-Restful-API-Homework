package kh.edu.istad.m1b02restfulapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiErrorRsponse<?>> handle(ResponseStatusException e) {
        ApiErrorRsponse<?> body = ApiErrorRsponse.builder()
                .code(e.getStatusCode().toString())
                .message(e.getReason())
                .build();
        return ResponseEntity.status(e.getStatusCode()).body(body);
    }
}
