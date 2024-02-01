/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ms.email.services.impls;

import com.ms.email.entities.Email;
import com.ms.email.enums.StatusEmail;
import com.ms.email.repositories.EmailRepository;
import com.ms.email.services.EmailService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author jacinto
 */
@Service
public class EmailServiceImpl implements EmailService{
    
    @Autowired
    private EmailRepository emailRepository;
    
    final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    
    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    @Override
    @Transactional
    public Email sendEmail(Email email) {
        try {
            
            email.setEmailFrom(emailFrom);
            email.setSendDataEmail(LocalDateTime.now());
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(email.getEmailTo());
            simpleMailMessage.setSubject(email.getSubject());
            simpleMailMessage.setText(email.getText());
            email.setStatusEmail(StatusEmail.SEND);
            javaMailSender.send(simpleMailMessage);
        } catch (MailException e) {
            email.setStatusEmail(StatusEmail.ERROR);
        } finally{
            return this.emailRepository.save(email);
        }
        
    }
    
    
    
}
