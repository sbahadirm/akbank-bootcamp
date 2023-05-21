package com.bahadirmemis.akbankbootcamp.controller;

import com.bahadirmemis.akbankbootcamp.AkbankBootcampApplication;
import com.bahadirmemis.akbankbootcamp.dto.CustomerSaveRequest;
import com.bahadirmemis.akbankbootcamp.enums.EnumStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;
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

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author bahadirmemis
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {AkbankBootcampApplication.class})
class CustomerControllerTest extends BaseTest {

  private static final String BASE_PATH = "/api/v1/customers";

  @Autowired
  private WebApplicationContext context;

  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
  }

  @Test
  void shouldFindAll() throws Exception {

    MvcResult mvcResult = mockMvc.perform(
                                     MockMvcRequestBuilders.get(BASE_PATH)
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
                                     MockMvcRequestBuilders.get(BASE_PATH + "/1000")
                                     //.param("id", "18") TODO: control
                                         ).andExpect(MockMvcResultMatchers.status().isOk())
                                 .andReturn();

    boolean success = isSuccess(mvcResult);

    assertTrue(success);
  }

  @Test
  void shouldSave() throws Exception {

    String body = "{\n"
                  + "  \"name\": \"yusuf\",\n"
                  + "  \"surname\": \"memis\",\n"
                  + "  \"username\": \"yusuf\",\n"
                  + "  \"password\": \"1231231234\",\n"
                  + "  \"email\": \"yusuf@memis.com\",\n"
                  + "  \"birthDate\": \"2023-05-21\",\n"
                  + "  \"status\": \"ACTIVE\"\n"
                  + "}";

    MvcResult mvcResult = mockMvc.perform(
                                     MockMvcRequestBuilders.post(BASE_PATH)
                                                           .content(body)
                                                           .contentType(MediaType.APPLICATION_JSON)
                                         ).andExpect(MockMvcResultMatchers.status().isOk())
                                 .andReturn();

    boolean success = isSuccess(mvcResult);

    assertTrue(success);
  }

  @Test
  void shouldSave2() throws Exception {

    CustomerSaveRequest customerSaveRequest =
        new CustomerSaveRequest("ayşe", "memiş", "ayse", "1231231234", "ayse@memis.com", LocalDate.now(),
                                EnumStatus.ACTIVE);

    String body = objectMapper.writeValueAsString(customerSaveRequest);

    MvcResult mvcResult = mockMvc.perform(
                                     MockMvcRequestBuilders.post(BASE_PATH)
                                                           .content(body)
                                                           .contentType(MediaType.APPLICATION_JSON)
                                         ).andExpect(MockMvcResultMatchers.status().isOk())
                                 .andReturn();

    boolean success = isSuccess(mvcResult);

    assertTrue(success);
  }

  @Test
  void shouldDelete() throws Exception {

    MvcResult mvcResult = mockMvc.perform(
                                     MockMvcRequestBuilders.delete(BASE_PATH + "/1001")
                                         ).andExpect(MockMvcResultMatchers.status().isOk())
                                 .andReturn();

    boolean success = isSuccess(mvcResult);

    assertTrue(success);
  }
}