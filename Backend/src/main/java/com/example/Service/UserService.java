package com.example.Service;

import com.example.Model.User;
import com.example.Model.Role;
import com.example.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(User user) {
        String normalizedEmail = user.getEmail().toLowerCase();
        if (userRepo.findByEmail(normalizedEmail) != null) {
            throw new IllegalArgumentException("Email already exists");
        }

        user.setEmail(normalizedEmail);

        System.out.println("Raw password: " + user.getPassword());
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        System.out.println("Encoded password (register): " + encodedPassword);

        user.setPassword(encodedPassword);

        if (user.getRole() == null) {
            user.setRole(Role.FARMER); // Default role
        }

        return userRepo.save(user);
    }

    public User authenticate(String email, String rawPassword) {
        User user = userRepo.findByEmail(email.toLowerCase());

        if (user == null) {
            throw new IllegalArgumentException("No user found with this email");
        }

        System.out.println("Raw password: " + rawPassword);
        System.out.println("Encoded password from DB: " + user.getPassword());

        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        return user;
    }

}
