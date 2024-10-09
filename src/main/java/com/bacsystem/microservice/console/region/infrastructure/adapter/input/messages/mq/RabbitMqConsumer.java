package com.bacsystem.microservice.console.region.infrastructure.adapter.input.messages.mq;


import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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
public class RabbitMqConsumer {


    @RabbitListener(queues = {"${spring.rabbitmq.queue-name}"})
    public void receivedMessage(String message) {
        log.info("message received {}", message);
    }

}
