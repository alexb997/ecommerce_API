package org.example.model;

import jakarta.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;

    private String name;
    private String description;
    private double price;
    private int stock;
}