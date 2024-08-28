package com.example.AdminProject.repository;

import com.example.AdminProject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
