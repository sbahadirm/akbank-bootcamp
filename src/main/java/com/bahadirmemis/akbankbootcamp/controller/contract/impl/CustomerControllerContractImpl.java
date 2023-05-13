package com.bahadirmemis.akbankbootcamp.controller.contract.impl;

import com.bahadirmemis.akbankbootcamp.controller.contract.CustomerControllerContract;
import com.bahadirmemis.akbankbootcamp.dto.CustomerDTO;
import com.bahadirmemis.akbankbootcamp.dto.CustomerSaveRequest;
import com.bahadirmemis.akbankbootcamp.entity.Customer;
import com.bahadirmemis.akbankbootcamp.mapper.CustomerMapper;
import com.bahadirmemis.akbankbootcamp.service.entityservice.CustomerEntityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@Service
@RequiredArgsConstructor
public class CustomerControllerContractImpl implements CustomerControllerContract {

  private final CustomerEntityService customerEntityService;

  @Override
  public CustomerDTO save(CustomerSaveRequest request) {

    Customer customer = CustomerMapper.INSTANCE.convertToCustomer(request);

    customer = customerEntityService.save(customer);

    return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
  }

  @Override
  public List<CustomerDTO> findAll() {
    List<Customer> customerList = customerEntityService.findAll();
    return CustomerMapper.INSTANCE.convertToCustomerDTOList(customerList);
  }

  @Override
  public void delete(Long id) {
    customerEntityService.delete(id);
  }
}
