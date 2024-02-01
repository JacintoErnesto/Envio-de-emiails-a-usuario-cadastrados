/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ms.email.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author jacinto
 */
@Configuration
public class RabbitMQConfig {
    
    @Value(value = "${spring.rabbitmq.queue.name}")
    private String queueName;

    
    @Bean
    public org.springframework.amqp.core.Queue queue() {
        return QueueBuilder.durable(queueName).build();
    }
    
    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
