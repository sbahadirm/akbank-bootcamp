package com.bahadirmemis.akbankbootcamp.transactional.util;

import com.bahadirmemis.akbankbootcamp.entity.Customer;
import org.springframework.util.StringUtils;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class TransactionalUtil {

    public static Customer getDummyCustomer(String suffix) {

        String testName = "test";
        if (StringUtils.hasText(suffix)) {
            testName = testName + "-" + suffix;
        }

        Customer cusCustomer = new Customer();
        cusCustomer.setName(testName);
        cusCustomer.setSurname(testName);
        cusCustomer.setUsername(testName);
        cusCustomer.setPassword("123");

        return cusCustomer;
    }
}
