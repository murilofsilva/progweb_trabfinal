package com.ufms.progweb.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "usuario")
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;
    
}
