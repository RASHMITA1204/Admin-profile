package com.example.AdminProject.controller;

import com.example.AdminProject.entity.Product;
import com.example.AdminProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        Product addedProduct = productService.addProduct(product);
        return ResponseEntity.ok("Product added successfully with ID: " + addedProduct.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(id, productDetails);
        return ResponseEntity.ok("Product updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}

