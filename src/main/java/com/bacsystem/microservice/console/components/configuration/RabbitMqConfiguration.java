package com.bacsystem.microservice.console.components.configuration;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMqConfiguration
 * <p>
 * RabbitMqConfiguration class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BACSYSTEM APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author cbaciliod
 * @author dbacilio88@outllok.es
 * @since 8/10/2024
 */

@Configuration
public class RabbitMqConfiguration {

    @Value("${spring.rabbitmq.queue-name}")
    private String queueName;
    @Value("${spring.rabbitmq.exchange-name}")
    private String exchangeName;
    @Value("${spring.rabbitmq.routing-key}")
    private String routingKey;

    // spring bean for rabbit queue
    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    // spring bean for rabbit exchange
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(exchangeName);
    }

    // binding between queue and exchange using routing key
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue())
                .to(topicExchange())
                .with(routingKey);
    }

    //connection factory
    //rabbit template
    //rabbit admin
}
