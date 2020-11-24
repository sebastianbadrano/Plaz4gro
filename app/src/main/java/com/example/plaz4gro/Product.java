package com.example.plaz4gro;

public class Product {
    private String name;
    private String farmer;
    private String quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFarmer() {
        return farmer;
    }

    public void setFarmer(String farmer) {
        this.farmer = farmer;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Product() {
    }

    public Product(String name, String farmer, String quantity) {
        this.name = name;
        this.farmer = farmer;
        this.quantity = quantity;
    }
}
