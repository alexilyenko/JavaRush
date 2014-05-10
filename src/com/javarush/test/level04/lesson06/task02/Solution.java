package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int a1 = Integer.parseInt(a);
        String b = br.readLine();
        int b1 = Integer.parseInt(b);
        String c = br.readLine();
        int c1 = Integer.parseInt(c);
        String d = br.readLine();
        int d1 = Integer.parseInt(d);

        if (a1>b1 && a1>c1 && a1>d1)
            System.out.println(a1);
        else if (b1>a1 && b1>c1 && b1>d1)
            System.out.println(b1);
        else if (c1>a1 && c1>b1 && c1>d1)
            System.out.println(c1);
        else
            System.out.println(d1);
    }
}
