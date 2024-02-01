/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ms.email.entities;

import com.ms.email.enums.StatusEmail;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

/**
 *
 * @author jacinto
 */
@Entity(name = "Email")
@Table(name = "email")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_email")
    private UUID idEmail;
    @Column(name = "email_from")
    private String emailFrom;
    @Column(name = "email_to")
    private String emailTo;
    @Column(name = "subject")
    private String subject;
    
    @Column(name = "id_user")
    private UUID idUser;
    
    @Column(name = "text", columnDefinition = "TEXT")
    private String text;
    
    private LocalDateTime sendDataEmail;
    @Enumerated(EnumType.STRING)
    private StatusEmail statusEmail;
    
    
}
