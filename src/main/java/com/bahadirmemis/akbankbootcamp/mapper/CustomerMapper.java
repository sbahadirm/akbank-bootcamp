package com.bahadirmemis.akbankbootcamp.mapper;

import com.bahadirmemis.akbankbootcamp.dto.CustomerDTO;
import com.bahadirmemis.akbankbootcamp.dto.CustomerSaveRequest;
import com.bahadirmemis.akbankbootcamp.entity.Customer;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author bahadirmemis
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  Customer convertToCustomer(CustomerSaveRequest customerSaveRequest);

  CustomerDTO convertToCustomerDTO(Customer customer);

  List<CustomerDTO> convertToCustomerDTOList(List<Customer> customerList);
}
