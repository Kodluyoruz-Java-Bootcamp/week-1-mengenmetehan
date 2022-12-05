package com.metehanmengen.app.week1.example10;

public class Product {
    private final String name;
    private final String category;
    private final double price;
    private final long stock;


    public Product(String name, String category, double price, long stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }


    public long getStock() {
        return stock;
    }

}
