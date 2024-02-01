/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ms.user.dtos;

import java.util.UUID;
import lombok.Data;

/**
 *
 * @author jacinto
 */
@Data
public class EmailDto {
    UUID idUser;
    String emailTo;
    String subject;
    String text;
}
