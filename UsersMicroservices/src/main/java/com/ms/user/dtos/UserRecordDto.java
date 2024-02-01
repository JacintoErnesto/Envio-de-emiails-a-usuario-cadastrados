/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.ms.user.dtos;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author jacinto
 */
public record UserRecordDto(@NotBlank String name,@NotBlank String email) {

}
