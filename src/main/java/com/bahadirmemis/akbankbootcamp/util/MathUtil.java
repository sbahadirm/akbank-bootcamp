package com.bahadirmemis.akbankbootcamp.util;

import com.bahadirmemis.akbankbootcamp.errormessages.GeneralErrorMessage;
import com.bahadirmemis.akbankbootcamp.general.BusinessException;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;

/**
 * @author bahadirmemis
 */
@Slf4j
public class MathUtil {

  public static BigDecimal sum(BigDecimal number1, BigDecimal number2){

    if (number1 == null || number2 == null){
      log.warn("MathUtil#sum -> numbers cannot be null! n1: {}, n2: {}", number1, number2);
      throw new BusinessException(GeneralErrorMessage.VALUES_CANNOT_BE_NULL);
    }

    return number1.add(number2);
  }
}
