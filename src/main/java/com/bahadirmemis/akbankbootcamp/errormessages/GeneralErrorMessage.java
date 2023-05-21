package com.bahadirmemis.akbankbootcamp.errormessages;

import com.bahadirmemis.akbankbootcamp.general.BaseErrorMessage;

/**
 * @author bahadirmemis
 */
public enum GeneralErrorMessage implements BaseErrorMessage {

  VALUES_CANNOT_BE_NULL("Values cannot be null");

  private String message;

  GeneralErrorMessage(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return message;
  }
}
