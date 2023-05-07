package com.bahadirmemis.akbankbootcamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bahadirmemis
 */
@RestController
public class TestController {

  // CONSTRUCTOR INJ.
  private final WebService webService;

  public TestController(WebService webService) {
    this.webService = webService;
  }

  // FIELD INJ.
  //@Autowired
  //private WebService webService;

  // SETTER INJ.
  //private WebService webService;
  //
  //@Autowired
  //public void setWebService(WebService webService) {
  //  this.webService = webService;
  //}

  @GetMapping("/test")
  public void test(){
    webService.convertResponse();
  }
}
