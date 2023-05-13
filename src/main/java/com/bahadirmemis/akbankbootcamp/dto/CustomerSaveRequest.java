package com.bahadirmemis.akbankbootcamp.dto;

import com.bahadirmemis.akbankbootcamp.enums.EnumStatus;
import java.time.LocalDate;

/**
 * @author bahadirmemis
 */
public record CustomerSaveRequest(String name,
                                  String surname,
                                  String username,
                                  String password,
                                  String email,
                                  LocalDate birthDate,
                                  EnumStatus status) {

}
