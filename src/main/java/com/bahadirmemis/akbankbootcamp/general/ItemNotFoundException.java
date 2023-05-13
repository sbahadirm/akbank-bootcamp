package com.bahadirmemis.akbankbootcamp.general;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author bahadirmemis
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends BusinessException{

  public ItemNotFoundException(BaseErrorMessage baseErrorMessage) {
    super(baseErrorMessage);
  }
}
