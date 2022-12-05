package com.metehanmengen.app.week1.example10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
    private final String name;
    private final String surname;

    private final int age;
    private ArrayList<Order> orderList = new ArrayList<>();

    public Client(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Client(String name, String surname, int age, Order order) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        add(order);
    }

    public boolean add (Order o)
    {
        if (o == null)
            return false;

        orderList.add(o);
        return true;
    }

    //Dizinin kopyası dışarıya veriliyor. Asıl dizide oynama yapılamaz.
    public List<Order> getOrderList()
    {
        ArrayList<Order> list = new ArrayList<>(orderList);

        return list;
    }

    public void printOrderList()
    {
        orderList.forEach(System.out::println);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

}
