package com.example.ECommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ECommerce.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUserId(Integer userId);
}
