package com.bahadirmemis.akbankbootcamp.general;

import jakarta.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author bahadirmemis
 */
@RestController
@ControllerAdvice
@Slf4j
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler
  public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest webRequest) {

    String message = e.getMessage();
    String description = webRequest.getDescription(false);

    var genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);
    var response = RestResponse.error(genericErrorMessage);

    log.error(genericErrorMessage.getMessage());

    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler
  public final ResponseEntity<Object> handleAllExceptions(TransactionSystemException e, WebRequest webRequest) {

    String message = e.getMessage();
    String description = webRequest.getDescription(false);

    var genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);
    var response = RestResponse.error(genericErrorMessage);

    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler
  public final ResponseEntity<Object> handleAllExceptions(BusinessException e, WebRequest webRequest) {

    String message = e.getBaseErrorMessage().getMessage();
    String description = webRequest.getDescription(false);

    var genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);
    var response = RestResponse.error(genericErrorMessage);

    log.warn(genericErrorMessage.getMessage());

    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
