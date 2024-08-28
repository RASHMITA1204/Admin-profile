package com.example.AdminProject.service;


import com.example.AdminProject.entity.Admin;
import com.example.AdminProject.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Admin register(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

    public Optional<Admin> findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }
    public boolean checkPassword(Admin admin,String rawPassword){
        return passwordEncoder.matches(rawPassword, admin.getPassword());
    }
}



