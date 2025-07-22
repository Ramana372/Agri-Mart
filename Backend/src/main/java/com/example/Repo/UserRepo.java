package com.example.Repo;

import com.example.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
    User findByUsername(String username);
    User findByEmail(String email);
}
