package com.bacsystem.microservice.console.region.infrastructure.adapter.input.messages.kafka.consumer;


import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * KafkaConsumer
 * <p>
 * KafkaConsumer class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BACSYSTEM APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author cbaciliod
 * @author dbacilio88@outllok.es
 * @since 7/10/2024
 */

@Log4j2
@Component
public class KafkaConsumer {

    @KafkaListener(topicPattern = "bacsystem-topic", groupId = "bacsystem-group")
    public void consumeEvent(@Payload(required = false) final String message) {
        log.info("message {}", message);
    }
}
