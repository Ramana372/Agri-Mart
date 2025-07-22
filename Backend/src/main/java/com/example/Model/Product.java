package com.example.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "productname")
    private String productname;
    private String description;
    private String location;
    private double price;
    private String ownerName;
    private String category;
}
