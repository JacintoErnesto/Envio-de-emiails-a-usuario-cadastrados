/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ms.user.services.impls;

import com.ms.user.dtos.UserRecordDto;
import com.ms.user.entities.User;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;
import com.ms.user.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jacinto
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserProducer userProducer;

    
    

    @Override
    @Transactional
    public User userCreate(UserRecordDto userRecordDto) {

        if (!this.userRepository.existsByEmail(userRecordDto.email())) {
            User newUser = new User();

            newUser.setName(userRecordDto.name());
            newUser.setEmail(userRecordDto.email());
            User userSave = this.userRepository.save(newUser);
            userProducer.publishMessageEmail(userSave);
            return userSave;
        }
        
        return null;

    }

}
