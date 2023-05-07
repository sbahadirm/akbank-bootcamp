package com.bahadirmemis.akbankbootcamp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author bahadirmemis
 */
@Component
@Qualifier("json")
//@Primary
public class ResponseConverterJson implements ResponseConverter {

  @Override
  public void convert() {
    System.out.println("JSON");
  }
}
