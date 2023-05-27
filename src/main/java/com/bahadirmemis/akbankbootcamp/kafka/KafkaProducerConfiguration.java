package com.bahadirmemis.akbankbootcamp.kafka;

import com.bahadirmemis.akbankbootcamp.client.MailSendRequest;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@EnableKafka
@Configuration
public class KafkaProducerConfiguration {

    @Value("${akbank.kafka.address}")
    private String kafkaAddress;

    @Bean
    public KafkaTemplate<String, MailSendRequest> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ProducerFactory producerFactory() {

        Map<String, Object> configMap = new HashMap<>();
        configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);
        configMap.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
        configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory(configMap);
    }
}
