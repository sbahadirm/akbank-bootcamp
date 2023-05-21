package com.bahadirmemis.akbankbootcamp.controller;

import com.bahadirmemis.akbankbootcamp.general.RestResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.UnsupportedEncodingException;
import org.springframework.test.web.servlet.MvcResult;

/**
 * @author bahadirmemis
 */
public class BaseTest {

  protected ObjectMapper objectMapper;

  protected boolean isSuccess(MvcResult mvcResult) throws JsonProcessingException, UnsupportedEncodingException {
    var restResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), RestResponse.class);

    boolean success = restResponse.isSuccess();
    return success;
  }
}
