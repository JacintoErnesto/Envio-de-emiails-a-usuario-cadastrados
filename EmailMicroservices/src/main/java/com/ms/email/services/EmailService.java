/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ms.email.services;

import com.ms.email.entities.Email;
import org.springframework.stereotype.Service;

/**
 *
 * @author jacinto
 */
@Service
public interface EmailService {
    Email sendEmail(Email email);
}
