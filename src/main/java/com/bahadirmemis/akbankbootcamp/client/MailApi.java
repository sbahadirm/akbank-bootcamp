package com.bahadirmemis.akbankbootcamp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author bahadirmemis
 */
@FeignClient(value = "mail", url = "http://localhost:8081/api/v1/mails")
public interface MailApi {

  @GetMapping("/default-mail-address")
  String getMailAddress();

  @PostMapping
  boolean sendMail(@RequestBody MailSendRequest mailSendRequest);

  @PutMapping("/{id}")
  String updatePrice(@PathVariable Long id, @RequestParam BigDecimal price);
}
