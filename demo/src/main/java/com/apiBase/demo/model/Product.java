package com.apiBase.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codProduct;
    private String name;
    private String brand;
    private String category;
    private double price;
    private int stock;
    private String description;

    public Product(){
    }

    public Product(String description, int stock, double price, String category, String mark, String name, Long codProduct) {
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.category = category;
        this.brand = mark;
        this.name = name;
        this.codProduct = codProduct;
    }

    public Long getCodProduct() {
        return codProduct;
    }

    public void setCodProduct(Long codProduct) {
        this.codProduct = codProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return brand;
    }

    public void setMark(String mark) {
        this.brand = mark;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
