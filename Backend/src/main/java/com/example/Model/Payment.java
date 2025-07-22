package com.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String description;
    private String ownerName;
    private String category;
    private double price;
    private int days;
    private double totalAmount;
    private String paymentMethod;
}
