package com.example.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String modelName;
    private String company;
    private int year;
    private String description;
    private String location;
    private double price;
    private String ownerName;
    private String category;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate availabilityStart;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate availabilityEnd;

    private String imagePath;
    @Transient
    private MultipartFile image;
}
