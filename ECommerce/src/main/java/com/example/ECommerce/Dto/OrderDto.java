package com.example.ECommerce.Dto;

import java.util.List;
import com.example.ECommerce.enums.OrderStatus;

public class OrderDto {

    private Integer userId;
    private List<OrderItemDto> items;
    private OrderStatus status;   // MUST BE ENUM
    private String createdAt;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<OrderItemDto> getItems() {
		return items;
	}
	public void setItems(List<OrderItemDto> items) {
		this.items = items;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
    
}
