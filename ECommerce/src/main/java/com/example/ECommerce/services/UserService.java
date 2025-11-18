package com.example.ECommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ECommerce.Dto.UserDto;
import com.example.ECommerce.entity.User;
import com.example.ECommerce.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User createUser(UserDto dto) {
        User u = new User();
        u.setName(dto.getName());
        u.setEmail(dto.getEmail());
        u.setPassword(dto.getPassword());
        u.setStreet(dto.getStreet());
        u.setCity(dto.getCity());
        u.setZip(dto.getZip());
        u.setCreatedAt(dto.getCreatedAt());
        return userRepo.save(u);
    }

    public User getUser(Integer id) {
        return userRepo.findById(id).orElse(null);
    }
    
    public User login(String email, String password) {
        User user = userRepo.findByEmail(email);

        if (user == null) {
            return null; // email not found
        }

        if (!user.getPassword().equals(password)) {
            return null; // wrong password
        }

        return user; // success
    }

    public User updateUser(Integer id, UserDto dto) {
        User u = userRepo.findById(id).orElse(null);
        if (u == null) return null;
        u.setName(dto.getName());
        u.setEmail(dto.getEmail());
        u.setPassword(dto.getPassword());
        u.setStreet(dto.getStreet());
        u.setCity(dto.getCity());
        u.setZip(dto.getZip());
        u.setCreatedAt(dto.getCreatedAt());
        return userRepo.save(u);
    }

    public void deleteUser(Integer id) {
        if (userRepo.existsById(id)) userRepo.deleteById(id);
    }
}
