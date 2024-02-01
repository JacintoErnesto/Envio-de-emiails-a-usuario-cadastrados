/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ms.user.repositories;

import com.ms.user.entities.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author jacinto
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID>{

    public boolean existsByEmail(String email);
    
}
