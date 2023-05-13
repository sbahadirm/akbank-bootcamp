package com.bahadirmemis.akbankbootcamp.errormessages;

import com.bahadirmemis.akbankbootcamp.general.BaseErrorMessage;

/**
 * @author bahadirmemis
 */
public enum CustomerErrorMessage implements BaseErrorMessage {

  CUSTOMER_NOT_FOUND("Customer not found!");

  private String message;

  CustomerErrorMessage(String message) {
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
