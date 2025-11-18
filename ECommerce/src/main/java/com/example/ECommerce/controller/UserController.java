package com.example.ECommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ECommerce.Dto.UserDto;
import com.example.ECommerce.entity.User;
import com.example.ECommerce.services.UserService;
@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@PostMapping("/login")
	public User login(@RequestBody UserDto dto) {

	    System.out.println("LOGIN REQUEST:");
	    System.out.println("Email from frontend = " + dto.getEmail());
	    System.out.println("Password from frontend = " + dto.getPassword());

	    User user = userService.login(dto.getEmail(), dto.getPassword());

	    if (user == null) {
	        System.out.println("LOGIN FAILED: No match in DB");
	    } else {
	        System.out.println("LOGIN SUCCESS: " + user.getEmail());
	    }

	    return user;
	}

	
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody UserDto dto) {
        return userService.createUser(dto);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "User deleted";
    }
}
