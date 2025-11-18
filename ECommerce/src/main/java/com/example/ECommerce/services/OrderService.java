package com.example.ECommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ECommerce.Dto.OrderDto;
import com.example.ECommerce.Dto.OrderItemDto;
import com.example.ECommerce.entity.Order;
import com.example.ECommerce.entity.OrderItem;
import com.example.ECommerce.entity.Product;
import com.example.ECommerce.entity.User;
import com.example.ECommerce.Repository.OrderRepository;
import com.example.ECommerce.Repository.ProductRepository;
import com.example.ECommerce.Repository.UserRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductRepository productRepo;

    public Order createOrder(OrderDto dto) {

        User user = userRepo.findById(dto.getUserId()).orElse(null);
        if (user == null) return null;

        List<OrderItem> items = new ArrayList<>();
        double total = 0;

        for (OrderItemDto it : dto.getItems()) {
            Product p = productRepo.findById(it.getProductId()).orElse(null);
            if (p == null) continue;

            // reduce stock if you want
            if (p.getStock() < it.getQty()) {
                // skip or throw - here we skip the item
                continue;
            }
            p.setStock(p.getStock() - it.getQty());
            productRepo.save(p);

            OrderItem oi = new OrderItem();
            oi.setProductId(it.getProductId());
            oi.setQuantity(it.getQty());
            oi.setPrice(p.getPrice());

            items.add(oi);
            total += p.getPrice() * it.getQty();
        }

        Order order = new Order();
        order.setUserId(dto.getUserId());
        order.setItems(items);
        order.setTotalAmount(total);
        order.setStatus(dto.getStatus());
        order.setCreatedAt(dto.getCreatedAt());

        return orderRepo.save(order);
    }

    public List<Order> getOrdersByUser(Integer userId) {
        return orderRepo.findByUserId(userId);
    }

    public void deleteOrder(Integer id) {
        if (orderRepo.existsById(id)) orderRepo.deleteById(id);
    }
    public Order getOrder(Integer id) {
        return orderRepo.findById(id).orElse(null);
    }

}
