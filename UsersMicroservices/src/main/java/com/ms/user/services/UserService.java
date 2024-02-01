/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ms.user.services;

import com.ms.user.dtos.UserRecordDto;
import com.ms.user.entities.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author jacinto
 */
@Service
public interface UserService {
    
    public User userCreate(UserRecordDto userRecordDto);
    
}
