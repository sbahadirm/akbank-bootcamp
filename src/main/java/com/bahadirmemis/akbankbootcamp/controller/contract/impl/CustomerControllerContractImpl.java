package com.bahadirmemis.akbankbootcamp.controller.contract.impl;

import com.bahadirmemis.akbankbootcamp.controller.contract.CustomerControllerContract;
import com.bahadirmemis.akbankbootcamp.dto.CustomerDTO;
import com.bahadirmemis.akbankbootcamp.dto.CustomerSaveRequest;
import com.bahadirmemis.akbankbootcamp.entity.Customer;
import com.bahadirmemis.akbankbootcamp.errormessages.CustomerErrorMessage;
import com.bahadirmemis.akbankbootcamp.general.BusinessException;
import com.bahadirmemis.akbankbootcamp.mapper.CustomerMapper;
import com.bahadirmemis.akbankbootcamp.service.entityservice.CustomerEntityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bahadirmemis
 */
@Service
@RequiredArgsConstructor
public class CustomerControllerContractImpl implements CustomerControllerContract {

  private final CustomerEntityService customerEntityService;

  @Transactional
  @Override
  public CustomerDTO save(CustomerSaveRequest request) {

    Customer customer = CustomerMapper.INSTANCE.convertToCustomer(request);

    customer = customerEntityService.save(customer);

    if (1==1){
      throw new RuntimeException("test");
    }

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

  @Override
  public CustomerDTO findById(Long id) {

    Customer customer = customerEntityService.findByIdWithControl(id);

    return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
  }
}
