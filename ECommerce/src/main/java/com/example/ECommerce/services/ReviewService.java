package com.example.ECommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ECommerce.Dto.ReviewDto;
import com.example.ECommerce.entity.Product;
import com.example.ECommerce.entity.Review;
import com.example.ECommerce.entity.User;
import com.example.ECommerce.Repository.ProductRepository;
import com.example.ECommerce.Repository.ReviewRepository;
import com.example.ECommerce.Repository.UserRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductRepository productRepo;

    public Review addReview(ReviewDto dto) {
        User user = userRepo.findById(dto.getUserId()).orElse(null);
        Product product = productRepo.findById(dto.getProductId()).orElse(null);
        if (user == null || product == null) return null;
        Review r = new Review();
        r.setUser(user);
        r.setProduct(product);
        r.setRating(dto.getRating());
        r.setComment(dto.getComment());
        return reviewRepo.save(r);
    }

    public void deleteReview(Integer id) {
        if (reviewRepo.existsById(id)) reviewRepo.deleteById(id);
    }
}
