package com.bahadirmemis.akbankbootcamp;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bahadirmemis
 */
@RestController
public class TestController {

  @RequestMapping(method = RequestMethod.GET, path = "/test1")
  public String get1(){
    String str = "get1";
    System.out.println(str);
    return str;
  }

  @GetMapping("/tests")
  public String get01(){
    String str = "get01";
    System.out.println(str);
    return str;
  }

  @PostMapping("/test01")
  public String post01(){
    String str = "post01";
    System.out.println(str);
    return str;
  }

  @PutMapping("/test01")
  public String put01(){
    String str = "put01";
    System.out.println(str);
    return str;
  }

  @PatchMapping("/test01")
  public String patch01(){
    String str = "patch01";
    System.out.println(str);
    return str;
  }

  @DeleteMapping("/test01")
  public String delete01(){
    String str = "delete01";
    System.out.println(str);
    return str;
  }










  //@GetMapping("/test")
  //public void test(){
  //  System.out.println("test");
  //}
}
