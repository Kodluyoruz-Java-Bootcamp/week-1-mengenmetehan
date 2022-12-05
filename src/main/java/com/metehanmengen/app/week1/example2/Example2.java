package com.metehanmengen.app.week1.example2;

public class Example2 {
    public static void run ()
    {
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k <= i; k++)
                System.out.print("*");
            System.out.println();
        }

        for (int i = 0; i < 5; i++) {
            for (int k = 4; k > i; k--)
                System.out.print(" ");
            for (int k = 0; k <= i; k++)
                System.out.print("*");
            System.out.println();
        }


    }
}
