package com.bahadirmemis.akbankbootcamp.general;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author bahadirmemis
 */
@Data
@AllArgsConstructor
public class GenericErrorMessage {

  private LocalDateTime errorDate;
  private String message;
  private String detail;
}
