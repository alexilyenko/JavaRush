package com.javarush.test.level13.lesson02.task05;

/* 4 ошибки
Исправь 4 ошибки в программе, чтобы она компилировалась.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {

        new Hobbie();
        System.out.println(Dream.HOBBIE.toString());
        System.out.println(new Hobbie().toString());

    }

        interface Desire
        {
        }
        interface Dream
        {
            public static Hobbie HOBBIE = new Hobbie();
        }

        static class Hobbie implements Dream, Desire
        {
            static int INDEX = 1;

            @Override
            public String toString()
            {
                INDEX++;
                return "" + INDEX;
            }
        }

}
