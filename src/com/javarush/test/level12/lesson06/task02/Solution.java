package com.javarush.test.level12.lesson06.task02;

/* Исправь код. Первая задача
Исправь код, чтобы программа компилировалась.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }


    public static abstract class Pet
    {
        public String getName()
        {
            return "Я - котенок";
        }

        public abstract Pet getChild();
    }

}
