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

    public User register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.FARMER);
        return userRepo.save(user);
    }

}
