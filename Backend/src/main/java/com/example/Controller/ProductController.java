package com.example.Controller;

import com.example.Model.Product;
import com.example.Service.ProductService;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Product addProduct(
            @RequestPart("image") MultipartFile image,
            @RequestPart("productName") String productName,
            @RequestPart("modelName") String modelName,
            @RequestPart("company") String company,
            @RequestPart("year") Integer year,
            @RequestPart("description") String description,
            @RequestPart("location") String location,
            @RequestPart("price") Double price,
            @RequestPart("ownerName") String ownerName,
            @RequestPart("category") String category,
            @RequestPart(value = "availabilityStart", required = false) String availabilityStart,
            @RequestPart(value = "availabilityEnd", required = false) String availabilityEnd
    ) throws IOException {

        Product product = new Product();
        product.setProductName(productName);
        product.setModelName(modelName);
        product.setCompany(company);
        product.setYear(year);
        product.setDescription(description);
        product.setLocation(location);
        product.setPrice(price);
        product.setOwnerName(ownerName);
        product.setCategory(category);

        if (availabilityStart != null && !availabilityStart.isBlank()) {
            product.setAvailabilityStart(LocalDate.parse(availabilityStart));
        }
        if (availabilityEnd != null && !availabilityEnd.isBlank()) {
            product.setAvailabilityEnd(LocalDate.parse(availabilityEnd));
        }

        if (image != null && !image.isEmpty()) {
            String uploadDir = "Uploads/";
            String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
            java.nio.file.Path filePath = java.nio.file.Paths.get(uploadDir + fileName);
            java.nio.file.Files.createDirectories(filePath.getParent());
            java.nio.file.Files.write(filePath, image.getBytes());

            product.setImagePath("/" + uploadDir + fileName);
        }

        return productService.addProduct(product);
    }




    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/byOwnername")
    public List<Product> getProductsByOwnerName(@RequestParam String name) {
        return productService.getProductsByOwnerName(name);
    }

    @GetMapping("/category/{type}")
    public List<Product> getByCategory(@PathVariable String type) {
        return productService.getByCategory(type);
    }

    @GetMapping("/admin/all")
    public List<Product> getAllProductsForAdmin() {
        return productService.getAllProducts(); // same logic reused
    }
}
