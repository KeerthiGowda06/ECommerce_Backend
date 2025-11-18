package com.example.ECommerce.Dto;

public class OrderItemDto {
    private Integer productId;
    private int qty;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

    
}
