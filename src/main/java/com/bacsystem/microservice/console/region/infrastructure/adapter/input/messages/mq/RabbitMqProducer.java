package com.bacsystem.microservice.console.region.infrastructure.adapter.input.messages.mq;


import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * RabbitMqProducer
 * <p>
 * RabbitMqProducer class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BACSYSTEM APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author cbaciliod
 * @author dbacilio88@outllok.es
 * @since 8/10/2024
 */

@Log4j2
@Service
public class RabbitMqProducer {

    @Value("${spring.rabbitmq.exchange-name}")
    private String exchange;
    @Value("${spring.rabbitmq.routing-key}")
    private String routingKey;
    @Value("${spring.rabbitmq.queue-name}")
    private String queueName;

    private final RabbitTemplate rabbitTemplate;

    public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(cron = "0 */1 * * * *")
    void send() {
        sendMessage("hola desde spring boot");
    }

    public void sendMessage(String message) {
        log.info("message send {}", message);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);

    }

}
