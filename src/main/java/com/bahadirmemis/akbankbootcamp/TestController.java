package com.bahadirmemis.akbankbootcamp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bahadirmemis
 */
@RestController
public class TestController {

  @GetMapping("/test")
  public void test(){
    System.out.println("test");
  }
}
