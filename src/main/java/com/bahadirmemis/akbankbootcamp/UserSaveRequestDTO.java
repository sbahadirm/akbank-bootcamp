package com.bahadirmemis.akbankbootcamp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author bahadirmemis
 */
public record UserSaveRequestDTO(@NotBlank String name,
                                 @NotBlank String surname) {

}
