package com.example.AdminProject.entity;

import jakarta.persistence.*;
import lombok.Data;

    @Entity
    @Data
    public class Admin {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String username;
        private String password;
        private String email;
        private String role;
    }

