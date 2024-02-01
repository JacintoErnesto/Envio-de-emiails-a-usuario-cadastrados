/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ms.email.consumers;

import com.ms.email.dtos.EmailRecordDto;
import com.ms.email.entities.Email;
import com.ms.email.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 *
 * @author jacinto
 */
@Component
public class EmailConsumer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue.name}")
    public void listenEmailQueue(@Payload EmailRecordDto emailRecordDto) {
        Email email = new Email();
        email.setIdUser(emailRecordDto.idUser());
        email.setEmailTo(emailRecordDto.emailTo());
        email.setSubject(emailRecordDto.subject());
        email.setText(emailRecordDto.text());
        this.emailService.sendEmail(email);
    }
}
