package com.metehanmengen.app.week1.example10;

public class Invoice {
    private final String name;
    private final double price;

    public Invoice(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
