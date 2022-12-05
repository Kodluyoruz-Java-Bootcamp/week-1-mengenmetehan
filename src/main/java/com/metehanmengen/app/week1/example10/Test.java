package com.metehanmengen.app.week1.example10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    /*

        Main Class içerisinde olan kodun aynısı, yedek tutuluyor.

     */


    public static void main()
    {
        Product phone = new Product("IPhone14", "Telephone", 40.500, 20);
        Product tv = new Product("SamsungUHD", "Television", 30.000, 50);
        Product pc = new Product("Monster", "Computer", 45.500, 70);

        Order o1 = new Order("phone", phone);
        Order o2 = new Order("tv", tv);
        Order o3 = new Order("pc", pc);

        o1.add(tv);
        o1.add(pc);
        o2.add(phone);

        /*
            o1 -> phone + tv + pc : 3 ürün = 40.5 + 30 + 45.5 = 116
            o2 -> tv + phone : 2 ürün = 70.5
            o3 -> pc : 1 ürün = 45.5
         */

        ArrayList<Client> clients = new ArrayList<>();

        Client metehan = new Client("Metehan", "Mengen", 26);
        metehan.add(o1); // 3 ürün
        clients.add(metehan);

        Client ali = new Client("Ahmet", "Akay", 32);
        ali.add(o2);
        ali.add(o1); // 5 ürün
        clients.add(ali);

        Client mehmet= new Client("Mehmet", "Yılmaz", 34);
        mehmet.add(o3);
        mehmet.add(o1); // 4 ürün
        clients.add(mehmet);

        Client cem = new Client("Cem", "Dırman", 29);
        cem.add(o2);
        cem.add(o2); // 4 ürün
        clients.add(cem);

        Client cemY = new Client("Cem", "Yılmaz", 38);
        cemY.add(o2); // 2 ürün
        clients.add(cemY);

        //Müşterileri yazdırıyoruz.

        System.out.println("Müşteri Listesi : ");
        clients.stream().map(c -> c.getName().concat(" " + c.getSurname())).forEach(System.out::println);
        System.out.println();

        //İsmi Cem olan müşterilerin aldıkları ürün sayısını buluyoruz.

        var countCemOrder = clients.stream().filter(client -> client.getName().equals("Cem"))
                .map(Client::getOrderList).collect(Collectors.toList());
        int countProduct = 0;

        for (List<Order> orderList : countCemOrder)
            for (Order o : orderList)
                countProduct += o.getProductList().size();

        System.out.printf("%s isimli müşterinin aldıkları ürün sayısı %d dir. \n", "Cem", countProduct);


        var countCemDırmanOrder = clients.stream().filter(client -> client.getName().equals("Cem"))
                .filter(client -> client.getSurname().equals("Dırman"))
                .map(Client::getOrderList).collect(Collectors.toList());
        int countProductCemDırman = 0;

        for (List<Order> orderList : countCemDırmanOrder)
            for (Order o : orderList)
                countProductCemDırman += o.getProductList().size();

        System.out.printf("%s isimli müşterinin aldıkları ürün sayısı %d dir.  \n \n", "Cem Dırman ", countProductCemDırman);

        // İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarını buluyoruz.

        List<Client> clientList = clients.stream().filter(client -> client.getName().equals("Cem"))
                .filter(client -> client.getAge() > 25 && client.getAge() < 30)
                .collect(Collectors.toList());

        List<List<Order>> orderList = clientList.stream().map(Client::getOrderList).collect(Collectors.toList());

        double price = 0;

        System.out.println("İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş listesi :");

        for (List<Order> orders: orderList)
            for (Order o : orders)
                price += o.getInvoicePrice();

        System.out.printf("İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarı %f dir", price);




    }
}
