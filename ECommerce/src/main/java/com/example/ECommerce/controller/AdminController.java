package com.example.ECommerce.controller;

import java.util.*;

import org.springframework.web.bind.annotation.*;

import com.example.ECommerce.entity.Admin;
import com.example.ECommerce.enums.AdminRole;
@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private List<Admin> adminList = new ArrayList<>();

    public AdminController() {
        adminList.add(new Admin("Manager Admin", "manager@gmail.com", "manager123", AdminRole.MANAGER));
        adminList.add(new Admin("Supervisor Admin", "supervisor@gmail.com", "super123", AdminRole.SUPERVISOR));
        adminList.add(new Admin("Agent Admin", "agent@gmail.com", "agent123", AdminRole.AGENT));
    }

    @GetMapping
    public List<Admin> getAdmins() {
        return adminList;
    }
}
