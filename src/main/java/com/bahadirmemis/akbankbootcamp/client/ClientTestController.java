package com.bahadirmemis.akbankbootcamp.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author bahadirmemis
 */
@RestController
@RequestMapping("api/v1/client-test")
@RequiredArgsConstructor
public class ClientTestController {

  private final MailApi mailApi;

  @GetMapping("/default-mail-address/with-rest-template")
  public String getDefaultMailInfo(){

    String url = "http://localhost:8081/api/v1/mails/default-mail-address";

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

    String body = responseEntity.getBody();

    return body;
  }

  @GetMapping("/default-mail-address/with-feign")
  public String getDefaultMailInfoWithFeign(){

    String mailAddress = mailApi.getMailAddress();
    return mailAddress;
  }

  @PostMapping
  public boolean sendMail(@RequestBody MailSendRequest mailSendRequest){

    for (int i = 1; i <= 10; i++){
      mailApi.sendMail(mailSendRequest);
    }

    return true;
  }
}
