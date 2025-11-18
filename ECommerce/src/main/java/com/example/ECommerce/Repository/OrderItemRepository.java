package com.example.ECommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ECommerce.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {}
