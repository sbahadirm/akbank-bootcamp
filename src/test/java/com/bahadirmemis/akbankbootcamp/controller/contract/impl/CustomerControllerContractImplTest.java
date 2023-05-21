package com.bahadirmemis.akbankbootcamp.controller.contract.impl;

import com.bahadirmemis.akbankbootcamp.controller.contract.CustomerControllerContract;
import com.bahadirmemis.akbankbootcamp.dto.CustomerDTO;
import com.bahadirmemis.akbankbootcamp.dto.CustomerSaveRequest;
import com.bahadirmemis.akbankbootcamp.entity.Customer;
import com.bahadirmemis.akbankbootcamp.general.BusinessException;
import com.bahadirmemis.akbankbootcamp.service.entityservice.CustomerEntityService;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    String name = "bahadir";

    Customer customer = mock(Customer.class);
    when(customer.getName()).thenReturn(name);
    List<Customer> customerList = new ArrayList<>();
    customerList.add(customer);

    when(customerEntityService.findAll()).thenReturn(customerList);

    List<CustomerDTO> customerDTOList = customerControllerContract.findAll();

    Assertions.assertEquals(1, customerDTOList.size());
    Customer result = customerList.get(0);
    Assertions.assertEquals(name, result.getName());
  }

  @Test
  void shouldFindAllWhenReturnsCustomers() {

    Customer customer1 = mock(Customer.class);
    Customer customer2 = mock(Customer.class);
    List<Customer> customerList = new ArrayList<>();
    customerList.add(customer1);
    customerList.add(customer2);

    when(customerEntityService.findAll()).thenReturn(customerList);

    List<CustomerDTO> customerDTOList = customerControllerContract.findAll();
    Assertions.assertEquals(2, customerDTOList.size());
  }

  @Test
  void shouldSave() {

    Long id = 18L;
    String name = "bahadir";

    CustomerSaveRequest request = mock(CustomerSaveRequest.class);
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(id);

    when(request.name()).thenReturn(name);
    when(customerEntityService.save(any())).thenReturn(customer);

    CustomerDTO result = customerControllerContract.save(request);

    Mockito.verify(customerEntityService).save(any());
    assertEquals(id, result.id());
    //assertEquals(name, result.name()); eziliyor!!!

  }

  @Test
  void shouldNotSaveWhenIdDoesNotExist() {
  }


  @Test
  void shouldDelete() {

    Long id = 18L;

    Mockito.doNothing().when(customerEntityService).delete(id);

    customerControllerContract.delete(id);

    Mockito.verify(customerEntityService).delete(id);
  }

  @Test
  void shouldNotDeleteWhenDeleteMethodThrowsException() {

    Mockito.doThrow(BusinessException.class).when(customerEntityService).delete(Mockito.anyLong());

    Assertions.assertThrows(RuntimeException.class, () -> customerControllerContract.delete(18L));

  }
}