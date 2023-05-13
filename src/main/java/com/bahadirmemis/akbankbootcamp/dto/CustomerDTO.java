package com.bahadirmemis.akbankbootcamp.dto;

import com.bahadirmemis.akbankbootcamp.enums.EnumStatus;
import java.time.LocalDate;

/**
 * @author bahadirmemis
 */
public record CustomerDTO(Long id,
                          String name,
                          String surname,
                          String username,
                          String email,
                          LocalDate birthDate,
                          EnumStatus status) {

}
