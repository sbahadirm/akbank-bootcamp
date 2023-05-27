package com.bahadirmemis.akbankbootcamp.kafka;

import com.bahadirmemis.akbankbootcamp.client.MailSendRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@RestController
@RequestMapping("api/v1/kafka")
@RequiredArgsConstructor
public class KafkaTestController {

    @Value("${akbank.kafka.topic}")
    private String topic;


    private final KafkaTemplate<String, MailSendRequest> kafkaTemplate;

    @PostMapping("/mails")
    public boolean sendMail(@RequestBody MailSendRequest mailSendRequest){

        kafkaTemplate.send(topic, UUID.randomUUID().toString(), mailSendRequest);

        return true;
    }
}
