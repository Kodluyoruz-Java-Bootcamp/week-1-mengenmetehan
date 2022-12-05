package com.metehanmengen.app.week1.example10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    private final String name;
    private final ArrayList<Product> productList = new ArrayList<>();


    private double totalOrderPrice() {
        double price = 0;

        for (Product p : productList)
            price += p.getPrice();

        return price;
    }

    public Order(String name, Product product) {
        this.name = name;
        add(product);
    }

    public boolean add (Product p)
    {
        if (p == null)
            return false;

        productList.add(p);
        return true;
    }

    public List<Product> getProductList()
    {
        var list = new ArrayList<Product>();

        list.addAll(productList);

        return list;
    }

    public void printOrderList()
    {
        productList.forEach(System.out::println);
    }

    public String getName() {
        return name;
    }


    public double getInvoicePrice()
    {
        StringBuilder sb = new StringBuilder();

        for (Product list: productList)
            sb.append(list.getName()).append('-');

        Invoice invoice = new Invoice(sb.toString(), totalOrderPrice());
        System.out.printf("%s siparişinin faturası : %f \n", invoice.getName(), invoice.getPrice());


        return totalOrderPrice();
    }

}
