package com.example.Controller;

import com.example.Model.User;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerSubmit(@RequestBody User user) {
        userService.register(user);
        return "Registered Successfully!";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "Welcome to AgriMart!";
    }
}
