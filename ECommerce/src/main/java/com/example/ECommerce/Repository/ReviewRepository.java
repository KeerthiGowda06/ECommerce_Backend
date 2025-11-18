package com.example.ECommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ECommerce.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByProductId(Integer productId);
    List<Review> findByUserId(Integer userId);
}
