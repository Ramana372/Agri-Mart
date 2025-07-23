package com.example.Repo;

import com.example.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByOwnerName(String name);
    List<Product> findByCategoryIgnoreCase(String category);
}