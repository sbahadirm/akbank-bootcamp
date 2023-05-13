package com.bahadirmemis.akbankbootcamp.controller;

import com.bahadirmemis.akbankbootcamp.controller.contract.CustomerControllerContract;
import com.bahadirmemis.akbankbootcamp.dto.CustomerDTO;
import com.bahadirmemis.akbankbootcamp.dto.CustomerSaveRequest;
import com.bahadirmemis.akbankbootcamp.general.RestResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

  private final CustomerControllerContract customerControllerContract;

  @PostMapping
  public ResponseEntity<RestResponse<CustomerDTO>> save(@RequestBody CustomerSaveRequest customerSaveRequest) {
    var customerDTO = customerControllerContract.save(customerSaveRequest);
    return ResponseEntity.ok(RestResponse.of(customerDTO));
  }

  @GetMapping
  public ResponseEntity<RestResponse<List<CustomerDTO>>> findAll() {
    var customerDTOList = customerControllerContract.findAll();
    return ResponseEntity.ok(RestResponse.of(customerDTOList));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id) {
    customerControllerContract.delete(id);
    return ResponseEntity.ok(RestResponse.empty());
  }
}
