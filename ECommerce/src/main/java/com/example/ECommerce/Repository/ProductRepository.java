package com.example.ECommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ECommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategory(String category);
}
