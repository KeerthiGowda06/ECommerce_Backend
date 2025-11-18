package com.example.ECommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ECommerce.Dto.ReviewDto;
import com.example.ECommerce.entity.Review;
import com.example.ECommerce.services.ReviewService;
@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public Review addReview(@RequestBody ReviewDto dto) {
        return reviewService.addReview(dto);
    }

    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Integer id) {
        reviewService.deleteReview(id);
        return "Review deleted";
    }
}
