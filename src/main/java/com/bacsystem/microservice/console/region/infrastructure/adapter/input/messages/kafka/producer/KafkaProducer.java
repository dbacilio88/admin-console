package com.bacsystem.microservice.console.region.infrastructure.adapter.input.messages.kafka.producer;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * KafkaProducer
 * <p>
 * KafkaProducer class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BACSYSTEM APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author cbaciliod
 * @author dbacilio88@outllok.es
 * @since 7/10/2024
 */

@EnableScheduling
@Log4j2
@Component
@RequiredArgsConstructor
public class KafkaProducer implements ApplicationListener<ApplicationReadyEvent> {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${microservices.consumer}")
    private boolean enable;
    @Value("${microservices.cron}")
    private String scheduler;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (enable) {
            consumerEvent();
        }
    }

    @Scheduled(cron = "${microservices.cron}")
    void consumerEvent() {

        if (enable) {
            log.info("cron {}", scheduler);
            for (int i = 0; i < 10; i++) {
                kafkaTemplate.send("bacsystem-topic", i + 1 + "", "Hello " + i);
            }
        }

        log.info("executed at {}", LocalDateTime.now());

    }

}
