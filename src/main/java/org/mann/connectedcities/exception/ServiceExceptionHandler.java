package org.mann.connectedcities.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ServiceExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        return new ResponseEntity<>("no", HttpStatus.OK);
    }
}
