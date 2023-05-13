package com.bahadirmemis.akbankbootcamp.controller.contract;

import com.bahadirmemis.akbankbootcamp.dto.CustomerDTO;
import com.bahadirmemis.akbankbootcamp.dto.CustomerSaveRequest;
import java.util.List;

/**
 * @author bahadirmemis
 */
public interface CustomerControllerContract {

  CustomerDTO save(CustomerSaveRequest request);

  List<CustomerDTO> findAll();

  void delete(Long id);
}
