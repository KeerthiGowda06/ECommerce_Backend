package com.example.ECommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ECommerce.entity.OrderItem;
import com.example.ECommerce.Repository.OrderItemRepository;

@Service
public class OrderItemService {

    @Autowired 
    OrderItemRepository itemRepo;

    public OrderItem addItem(OrderItem item) {
        return itemRepo.save(item);
    }

    public void deleteItem(Integer id) {
        itemRepo.deleteById(id);
    }
}
