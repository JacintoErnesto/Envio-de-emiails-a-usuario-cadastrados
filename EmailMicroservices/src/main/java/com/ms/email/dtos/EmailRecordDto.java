/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.ms.email.dtos;

import java.util.UUID;

/**
 *
 * @author jacinto
 */
public record EmailRecordDto(UUID idUser, String emailTo, String subject,String text) {

}
