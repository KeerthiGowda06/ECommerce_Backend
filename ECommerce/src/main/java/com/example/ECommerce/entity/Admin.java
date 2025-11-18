package com.example.ECommerce.entity;

import jakarta.persistence.*;
import com.example.ECommerce.enums.AdminRole;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private AdminRole role;

    public Admin() {}
    

	public Admin(String name, String email, String password, AdminRole role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
