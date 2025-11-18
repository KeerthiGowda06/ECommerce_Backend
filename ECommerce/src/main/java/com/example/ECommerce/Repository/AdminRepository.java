package com.example.ECommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ECommerce.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByEmail(String email);
}
