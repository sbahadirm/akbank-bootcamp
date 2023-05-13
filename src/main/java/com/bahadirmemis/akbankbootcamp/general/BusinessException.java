package com.bahadirmemis.akbankbootcamp.general;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author bahadirmemis
 */
@Data
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@RequiredArgsConstructor
public class BusinessException extends RuntimeException{

  private final BaseErrorMessage baseErrorMessage;
}
