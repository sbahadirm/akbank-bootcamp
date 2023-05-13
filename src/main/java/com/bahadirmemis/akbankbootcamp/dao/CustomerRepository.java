package com.bahadirmemis.akbankbootcamp.dao;

import com.bahadirmemis.akbankbootcamp.entity.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author bahadirmemis
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  /**
   * select * from customer where username = "bahadir";
   */
  @Query(
      "select customer from Customer customer where customer.username = :username "
  )
  Customer findByUsername(String username);

  /**
   * select * from customer
   * where name="bahadir" and surname = "memis";
   */
  Customer findByNameAndSurname(String name, String surname);

  /**
   * select * from customer
   * where id between 18 and 34
   */
  List<Customer> findAllByIdBetween(Long first, Long last);

  /**
   * select * from customer
   * where id > 18
   */
  List<Customer> findAllByIdGreaterThan(Long id);

  /**
   * select * from customer
   * where id >= 18
   */
  List<Customer> findAllByIdGreaterThanEqual(Long id);


}
