package com.example.Controller;

import com.example.Model.User;
import com.example.Repo.UserRepo;
import com.example.Service.UserService;
import com.example.Security.JwtUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:63342")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<String> registerSubmit(@RequestBody User user) {
        try {
            userService.register(user);
            return ResponseEntity.ok("Registered Successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody(required = true) Map<String, String> loginRequest) {
        String email = loginRequest.get("email").toLowerCase();
        String password = loginRequest.get("password");

        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            userService.authenticate(email, password);
            String jwt = jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(Map.of("token", jwt));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body(Map.of("error", e.getMessage()));
        }
    }
    @GetMapping("/getToken")
    public String getToken(@RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        return null;
    }

    @GetMapping("/admin/farmers")
    public List<User> getAllFarmers() {
        return userRepo.findByRole("FARMER");
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            return ResponseEntity.ok("Logged out successfully!");
        }
        return ResponseEntity.badRequest().body("Invalid token!");
    }
}
