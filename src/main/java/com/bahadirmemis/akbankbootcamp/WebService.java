package com.bahadirmemis.akbankbootcamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Qualifier > Primary > Autowiring by name
 *
 * @author bahadirmemis
 */
@Service
public class WebService {


  //private ResponseConverter responseConverter;
  //
  //public WebService(@Qualifier("json") ResponseConverter responseConverter) {
  //  this.responseConverter = responseConverter;
  //}

  //@Qualifier("json")
  //@Autowired
  //private ResponseConverter responseConverter;

  //private ResponseConverter responseConverter;
  //
  //@Autowired
  //public void setResponseConverter(@Qualifier("json") ResponseConverter responseConverter) {
  //  this.responseConverter = responseConverter;
  //}

  @Autowired
  private ResponseConverter responseConverterXml;

  public void convertResponse(){
    responseConverterXml.convert();
  }
}
