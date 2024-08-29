package com.example.AdminProject.controller;

import com.example.AdminProject.entity.Admin;
import com.example.AdminProject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<Admin> register(@RequestBody Admin admin) {
        Admin registeredAdmin = adminService.register(admin);
        return ResponseEntity.ok(registeredAdmin);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Admin loginRequest) {
        Optional<Admin> adminOpt = adminService.findByUsername(loginRequest.getUsername());
        if (adminOpt.isPresent()) {
            Admin admin = adminOpt.get();
            boolean isPasswordMatch = adminService.checkPassword(admin, loginRequest.getPassword());

            if (isPasswordMatch) {
                return ResponseEntity.ok("Login successful!");
            } else {
                return ResponseEntity.status(401).body("Invalid username or password.");
            }
        } else {
            return ResponseEntity.status(401).body("Invalid username or password.");
        }
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
//        Optional<Admin> adminOpt = adminService.findById(id);
//        if (adminOpt.isPresent()) {
//            Admin admin = adminOpt.get();
//            return ResponseEntity.ok(admin);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}



