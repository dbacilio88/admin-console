package com.bacsystem.microservice.console.region.infrastructure.adapter.input.messages.kafka;


import com.bacsystem.microservice.console.region.application.port.input.IMessageBrokerInputPort;
import com.bacsystem.microservice.console.region.infrastructure.adapter.input.messages.kafka.utils.ConversionUtils;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * KafkaMessage
 * <p>
 * KafkaMessage class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BACSYSTEM APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author cbaciliod
 * @author dbacilio88@outllok.es
 * @since 2/10/2024
 */
@Log4j2
@Component
@AllArgsConstructor
public class KafkaMessage {

    private final IMessageBrokerInputPort messageBrokerInputPort;

    //@KafkaListener(topicPattern = "dbserver1.public.*", groupId = "group1")
    public void consumeEvent(@Payload(required = false) final String message) {
        log.info("message {} ", message);
        if (message == null) {
            return;
        }
        Map<String, Object> event = ConversionUtils.jsonstring2Map(message);
        log.info("event {}", event);
        Map<String, Object> payload = (Map<String, Object>) event.get("payload");
        log.info("payload {}", payload);
        String operation = (String) payload.get("op");
        log.info("operation {}", operation);
        String table = (String) ((Map<String, Object>) payload.get("source")).get("table");
        log.info("table {}", table);
        if (operation.equals("u")) {
            messageBrokerInputPort.updateReg(table, (Map<String, Object>) payload.get("after"));
        } else if (operation.equals("c")) {
            messageBrokerInputPort.insertReg(table, (Map<String, Object>) payload.get("after"));
        } else if (operation.equals("d")) {
            messageBrokerInputPort.deleteReg(table, (Map<String, Object>) payload.get("before"));
        }
    }
}
