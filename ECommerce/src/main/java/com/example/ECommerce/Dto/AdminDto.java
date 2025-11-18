package com.example.ECommerce.Dto;

import com.example.ECommerce.enums.AdminRole;

public class AdminDto {
    private String name;
    private String email;
    private String password;
    private AdminRole role;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AdminRole getRole() {
		return role;
	}
	public void setRole(AdminRole role) {
		this.role = role;
	}

    
}
