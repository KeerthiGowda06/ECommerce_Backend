package com.example.ECommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ECommerce.Dto.ProductDto;
import com.example.ECommerce.entity.Product;
import com.example.ECommerce.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    // ⭐ GET ALL PRODUCTS (Required for frontend)
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // CREATE
    @PostMapping
    public Product createProduct(@RequestBody ProductDto dto) {
        return productService.addProduct(dto);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id) {
        return productService.getProduct(id);
    }

    // GET BY CATEGORY
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return productService.getByCategory(category);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody ProductDto dto) {
        return productService.updateProduct(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "Product deleted";
    }
}
