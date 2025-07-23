package com.example.Service;

import com.example.Model.Product;
import com.example.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productrepo;

    public Product addProduct(Product product) {
        try {
            MultipartFile file = product.getImage();

            if (file != null && !file.isEmpty()) {
                Path uploadDir = Paths.get("Uploads");
                if (!Files.exists(uploadDir)) {
                    Files.createDirectories(uploadDir);
                }

                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                Path filePath = uploadDir.resolve(fileName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                product.setImagePath("Uploads/" + fileName);
            }

            return productrepo.save(product);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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

    public Product getProductById(Long id) {
        Optional<Product> productOptional = productrepo.findById(id);
        return productOptional.orElse(null);
    }
}
