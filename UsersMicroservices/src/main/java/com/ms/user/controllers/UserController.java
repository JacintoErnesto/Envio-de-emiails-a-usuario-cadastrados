/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ms.user.controllers;

import com.ms.user.dtos.UserRecordDto;
import com.ms.user.entities.User;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jacinto
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/user_create")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserRecordDto userRecordDto)
    {
        if(this.userService.userCreate(userRecordDto) == null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(this.userService.userCreate(userRecordDto));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.userCreate(userRecordDto));
    }
}
