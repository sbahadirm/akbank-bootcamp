package com.bahadirmemis.akbankbootcamp.util;

import com.bahadirmemis.akbankbootcamp.errormessages.GeneralErrorMessage;
import com.bahadirmemis.akbankbootcamp.general.BusinessException;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bahadirmemis
 */
class MathUtilTest {

  @Test
  void shouldSum() {

    BigDecimal number1 = BigDecimal.valueOf(1);
    BigDecimal number2 = BigDecimal.valueOf(5);

    BigDecimal result = MathUtil.sum(number1, number2);

    Assertions.assertEquals(BigDecimal.valueOf(6), result);
  }

  //@Test
  //void shouldNotSumWhenNumber1IsNull(){
  //
  //  BigDecimal number1 = null;
  //  BigDecimal number2 = BigDecimal.valueOf(5);
  //
  //  BusinessException businessException = assertThrows(BusinessException.class, () -> MathUtil.sum(number1, number2));
  //
  //  assertEquals(GeneralErrorMessage.VALUES_CANNOT_BE_NULL, businessException.getBaseErrorMessage());
  //}

  //@Test
  //void shouldNotSumWhenNumber2IsNull(){
  //
  //  BigDecimal number1 = BigDecimal.valueOf(5);
  //  BigDecimal number2 = null;
  //
  //  BusinessException businessException = assertThrows(BusinessException.class, () -> MathUtil.sum(number1, number2));
  //
  //  assertEquals(GeneralErrorMessage.VALUES_CANNOT_BE_NULL, businessException.getBaseErrorMessage());
  //}

  @Test
  void shouldSumWhenNumber1IsNegative(){

    BigDecimal number1 = BigDecimal.valueOf(-3);
    BigDecimal number2 = BigDecimal.valueOf(4);

    BigDecimal result = MathUtil.sum(number1, number2);

    Assertions.assertEquals(BigDecimal.valueOf(1), result);
  }
}