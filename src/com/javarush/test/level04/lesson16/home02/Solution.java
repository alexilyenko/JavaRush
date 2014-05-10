package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int max, mid, min;
        if (a<b && a<c) {
            min = a;
            if (b>c) {
                max = b;
                mid = c;
            } else {
                max = c;
                mid = b;
            }
        }
        else if (b<a && b<c) {
            min = b;
            if (a>c) {
                max = a;
                mid = c;
            } else {
                max = c;
                mid = a;
            }
        }
        else {
            min =c;
            if (a>b) {
                max = a;
                mid = b;
            } else {
                max = b;
                mid = a;
            }
        }
        System.out.println(mid);
    }
}
