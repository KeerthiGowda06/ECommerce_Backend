package com.example.ECommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ECommerce.entity.Admin;
import com.example.ECommerce.Repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepo;

    public Admin findByEmail(String email) {
        return adminRepo.findByEmail(email);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepo.save(admin);
    }
}
