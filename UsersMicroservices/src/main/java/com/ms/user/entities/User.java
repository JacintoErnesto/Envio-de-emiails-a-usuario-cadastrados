/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ms.user.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

/**
 *
 * @author jacinto
 */
@Entity(name = "Users")
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
    
    private static  final long  serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_users")
    private UUID idUsers;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    
}
