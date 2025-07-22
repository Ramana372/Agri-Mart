package com.example.Service;

import com.example.Model.Product;
import com.example.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productrepo;

    public Product addProduct(Product product) {
        return productrepo.save(product);
    }

    public List<Product> getAllProducts() {
        return productrepo.findAll();
    }

    public List<Product> getProductsByOwnerName(String name) {
        return productrepo.findByOwnerName(name);
    }

    public List<Product> getByCategory(String category) {
        return productrepo.findByCategoryIgnoreCase(category);
    }
}
