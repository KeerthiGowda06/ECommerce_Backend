package com.example.ECommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ECommerce.Dto.ProductDto;
import com.example.ECommerce.entity.Product;
import com.example.ECommerce.Repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    // ⭐ GET ALL PRODUCTS
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    // ⭐ CREATE PRODUCT
    public Product addProduct(ProductDto dto) {
        Product product = new Product();

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setCategory(dto.getCategory());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setTags(dto.getTags());

        return productRepo.save(product);
    }

    // ⭐ GET PRODUCT BY ID
    public Product getProduct(Integer id) {
        return productRepo.findById(id).orElse(null);
    }

    // ⭐ GET PRODUCTS BY CATEGORY
    public List<Product> getByCategory(String category) {
        return productRepo.findByCategory(category);
    }

    // ⭐ UPDATE PRODUCT
    public Product updateProduct(Integer id, ProductDto dto) {
        return productRepo.findById(id).map(existing -> {

            existing.setName(dto.getName());
            existing.setDescription(dto.getDescription());
            existing.setCategory(dto.getCategory());
            existing.setPrice(dto.getPrice());
            existing.setStock(dto.getStock());
            existing.setTags(dto.getTags());

            return productRepo.save(existing);

        }).orElse(null);
    }

    // ⭐ DELETE PRODUCT
    public void deleteProduct(Integer id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
        }
    }
}
