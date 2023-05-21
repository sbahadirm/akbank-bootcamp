package com.bahadirmemis.akbankbootcamp.controller;

import com.bahadirmemis.akbankbootcamp.AkbankBootcampApplication;
import com.bahadirmemis.akbankbootcamp.general.RestResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bahadirmemis
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {AkbankBootcampApplication.class})
class CustomerControllerTest extends BaseTest{

  @Autowired
  private WebApplicationContext context;

  private MockMvc mockMvc;

  @BeforeEach
  void setUp(){
    mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
  }

  @Test
  void shouldFindAll() throws Exception {

    MvcResult mvcResult = mockMvc.perform(
                                     MockMvcRequestBuilders.get("/api/v1/customers")
                                         //.content("")
                                         //.contentType(MediaType.APPLICATION_JSON)
                                         )
                                 .andExpect(MockMvcResultMatchers.status().isOk())
                                 .andReturn();

    boolean success = isSuccess(mvcResult);

    assertTrue(success);
  }

  @Test
  void shouldFindById() throws Exception {
    MvcResult mvcResult = mockMvc.perform(
                                     MockMvcRequestBuilders.get("/api/v1/customers/2")
                                                           //.param("id", "18") TODO: control
                                         ).andExpect(MockMvcResultMatchers.status().isOk())
                                 .andReturn();

    boolean success = isSuccess(mvcResult);

    assertTrue(success);
  }


}