package com.bahadirmemis.akbankbootcamp.service.entityservice;

import com.bahadirmemis.akbankbootcamp.dao.CustomerRepository;
import com.bahadirmemis.akbankbootcamp.entity.Customer;
import com.bahadirmemis.akbankbootcamp.general.BaseEntityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@Service
public class CustomerEntityService extends BaseEntityService<Customer, CustomerRepository> {

  public CustomerEntityService(CustomerRepository repository) {
    super(repository);
  }

  //private final CustomerRepository customerRepository;
  //
  //public Customer save(Customer entity){
  //  return customerRepository.save(entity);
  //}
  //
  //public List<Customer> findAll() {
  //  return customerRepository.findAll();
  //}
}
