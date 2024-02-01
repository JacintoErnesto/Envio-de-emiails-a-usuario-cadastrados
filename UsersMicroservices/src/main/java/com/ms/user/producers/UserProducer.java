/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ms.user.producers;

import com.ms.user.dtos.EmailDto;
import com.ms.user.entities.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author jacinto
 */
@Component
public class UserProducer {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Value(value = "${spring.rabbitmq.queue.name}")
    private String routingKey; 
    
    public void publishMessageEmail(User user){
        EmailDto emailDto = new EmailDto();
        emailDto.setIdUser(user.getIdUsers());
        emailDto.setEmailTo(user.getEmail());
        emailDto.setSubject("Cadastro feito com sucesso");
        emailDto.setText(user.getName() + ", Seja bem vindo(a)! \n Agredecemos o seu cadastro aproveita os planos do nosso site e fique por dentro de todas a novidades" );
        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
    
}
