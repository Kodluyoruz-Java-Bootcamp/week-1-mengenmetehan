package com.metehanmengen.app.week1.example1;

public class Example1 {
/*
    47 sayısını ters çevirip kendisiyle toplarsak; 47 + 74 = 121, bir palindromik sayı elde etmiş
    oluruz. Bu prosedürle, yani ters çevirip kendisiyle toplayarak, her sayıdan bir palindromik sayı
    üretmek bu kadar kolay değildir. Bazı sayılar için bu işlemi defalarca tekrar ederek bir
    palindromik sayıya ulaşırız. Örneğin, 349 sayısı için bu işlemi 3 kez zincirleme olarak
    tekrarlamamız gerekmektedir: (10 PUAN)
     349 + 943 = 1292
     1292 + 2921 = 4213  4213 + 3124 = 7337
    (palindrome sayı değil) (palindrome sayı değil) (palindrome sayı)
    Buna göre, 10’dan 100’e kadar olan sayılardan bu prosedürle bir palindromik sayı elde edene kadar
    hangi sayı için en uzun zincirin oluşacağını bulan ve zinciri ekrana yazdıran programı yazınız.
 */
public static void run ()
{
    int longestPalindromeChain = longestChain(10, 100);
    longestPath(longestPalindromeChain);

}

    private static void longestPath (long n)
    {
        int idx = 1;
        while (!isPalindrome(n)){
            long reversedNumber = reversedNumber(n);
            long newNumber = reversedNumber + n;
            System.out.printf("%d. %d + %d = %d", idx++, n, reversedNumber, newNumber);
            System.out.println();
            n = newNumber;
        }


    }

    // 10 ile 100 arasında en uzun palindrom zincirini bulan metot
    private static int longestChain(int start, int bound)
    {
        int count = 20, number = 0;

        for (int i = start; i < bound; i++) {          // 349 943 = 123124
            if (count <= isLongestPalindrome(i)){
                count = isLongestPalindrome(i);
                number = i;
            }
        }
        return number;
    }

    private static int isLongestPalindrome(long n)
    {
        //kaçıncı döngüde palindrom olduğu sayılıyor.
        int count = 0;

        while (!isPalindrome(n)) {
            count++;
            n += reversedNumber(n);
        }
        return count;
    }

    private static boolean isPalindrome(long n)
    {
        return (reversedNumber(n) == n);
    }

    private static long reversedNumber (long n)
    {
        long result = 0;
        while (n != 0) {
            result = result * 10 + n % 10;
            n /= 10;
        }
        return result;
    }


}
