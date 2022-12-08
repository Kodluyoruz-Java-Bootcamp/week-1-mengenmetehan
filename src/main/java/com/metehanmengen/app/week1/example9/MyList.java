package com.metehanmengen.app.week1.example9;

import java.util.Arrays;
import java.util.Objects;

public class MyList<S> {
    private static final int DEFAULT_CAPACITY = 5;
    private static String[] elems = new String[DEFAULT_CAPACITY]; // 5 elemanlı boş String dizisi tutuluyor,
    private int index; //dizinin dolu eleman sayısını tutuyor.
    private final int incrementCapacity = 7; //kapasite artış miktarı


    public boolean add (String s)
    {
        if (s.charAt(0) != 'C')
            return false;

        if (index == elems.length - 1)
            changeCapacity();

        elems[index++] = s;
        return true;
    }

   public void print()
   {
       Arrays.stream(elems).filter(Objects::nonNull).forEach(s -> System.out.printf("%s ", s));
   }

   private void changeCapacity() {
        int len = elems.length + incrementCapacity;
        elems = Arrays.copyOf(elems, len);
   }
}


