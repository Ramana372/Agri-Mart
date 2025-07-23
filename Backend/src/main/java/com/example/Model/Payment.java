package com.example.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "productname")
    private String productName;

    private String modelName;
    private String company;
    private int year;

    private String description;
    private String location;
    private double price;
    private String ownerName;
    private String category;

    private String startDate;
    private String endDate;

    private String paymentMethod;
    private int days;
    private double totalAmount;
}