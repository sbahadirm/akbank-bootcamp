package com.bahadirmemis.akbankbootcamp.controller;

import com.bahadirmemis.akbankbootcamp.entity.Customer;
import com.bahadirmemis.akbankbootcamp.service.entityservice.CustomerEntityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bahadirmemis
 */
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerEntityService customerEntityService;

  @PostMapping
  public Customer save(@RequestBody Customer customer){
    return customerEntityService.save(customer);
  }

  @GetMapping
  public List<Customer> findAll(){
    return customerEntityService.findAll();
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id){
    customerEntityService.delete(id);
  }
}
