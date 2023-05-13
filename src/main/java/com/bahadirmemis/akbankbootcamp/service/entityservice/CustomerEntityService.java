package com.bahadirmemis.akbankbootcamp.service.entityservice;

import com.bahadirmemis.akbankbootcamp.dao.CustomerRepository;
import com.bahadirmemis.akbankbootcamp.entity.Customer;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@Service
@RequiredArgsConstructor
public class CustomerEntityService {

  private final CustomerRepository customerRepository;

  public Customer save(Customer customer){
    return customerRepository.save(customer);
  }

  public List<Customer> findAll() {
    return customerRepository.findAll();
  }
}
