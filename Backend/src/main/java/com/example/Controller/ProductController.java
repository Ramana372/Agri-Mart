package com.example.Controller;

import com.example.Model.Product;
import com.example.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/byOwnername")
    public List<Product> getProductsByOwnerName(@RequestParam String name){
        return productService.getProductsByOwnerName(name);
    }

    @GetMapping("/category/{type}")
    public List<Product> getByCategory(@PathVariable String type) {
        return productService.getByCategory(type);
    }
}
