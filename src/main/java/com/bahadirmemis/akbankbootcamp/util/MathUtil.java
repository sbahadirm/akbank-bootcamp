package com.bahadirmemis.akbankbootcamp.util;

import com.bahadirmemis.akbankbootcamp.errormessages.GeneralErrorMessage;
import com.bahadirmemis.akbankbootcamp.general.BusinessException;
import java.math.BigDecimal;

/**
 * @author bahadirmemis
 */
public class MathUtil {

  public static BigDecimal sum(BigDecimal number1, BigDecimal number2){

    if (number1 == null || number2 == null){
      throw new BusinessException(GeneralErrorMessage.VALUES_CANNOT_BE_NULL);
    }

    return number1.add(number2);
  }
}
