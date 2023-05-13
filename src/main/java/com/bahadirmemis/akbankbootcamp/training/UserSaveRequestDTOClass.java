package com.bahadirmemis.akbankbootcamp.training;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author bahadirmemis
 */
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class UserSaveRequestDTOClass {

  private final String name;
  private String surname;

}
