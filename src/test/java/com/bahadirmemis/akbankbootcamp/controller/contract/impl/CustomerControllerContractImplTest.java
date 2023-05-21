package com.bahadirmemis.akbankbootcamp.controller.contract.impl;

import com.bahadirmemis.akbankbootcamp.controller.contract.CustomerControllerContract;
import com.bahadirmemis.akbankbootcamp.dto.CustomerDTO;
import com.bahadirmemis.akbankbootcamp.entity.Customer;
import com.bahadirmemis.akbankbootcamp.service.entityservice.CustomerEntityService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bahadirmemis
 */
@ExtendWith(MockitoExtension.class)
class CustomerControllerContractImplTest {

  @Mock
  private CustomerEntityService customerEntityService;

  @InjectMocks
  private CustomerControllerContractImpl customerControllerContract;

  @Test
  void shouldFindAll() {
    List<CustomerDTO> customerDTOList = customerControllerContract.findAll();
    Assertions.assertEquals(0, customerDTOList.size());
  }

  @Test
  void shouldFindAllWhenReturnsCustomer() {

    Customer customer = Mockito.mock(Customer.class);
    List<Customer> customerList = new ArrayList<>();
    customerList.add(customer);

    Mockito.when(customerEntityService.findAll()).thenReturn(customerList);

    List<CustomerDTO> customerDTOList = customerControllerContract.findAll();
    Assertions.assertEquals(1, customerDTOList.size());
  }

  @Test
  void shouldFindAllWhenReturnsCustomers() {

    Customer customer1 = Mockito.mock(Customer.class);
    Customer customer2 = Mockito.mock(Customer.class);
    List<Customer> customerList = new ArrayList<>();
    customerList.add(customer1);
    customerList.add(customer2);

    Mockito.when(customerEntityService.findAll()).thenReturn(customerList);

    List<CustomerDTO> customerDTOList = customerControllerContract.findAll();
    Assertions.assertEquals(2, customerDTOList.size());
  }

  @Test
  void shouldSave() {
  }

  @Test
  void shouldNotSaveWhenIdDoesNotExist() {
  }


  @Test
  void shouldDelete() {
  }
}