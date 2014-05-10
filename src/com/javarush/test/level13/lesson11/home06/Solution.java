package com.javarush.test.level13.lesson11.home06;

/* Исправление ошибок
1. Переделай наследование в классах и интерфейсах так, чтобы программа компилировалась и продолжала делать то же самое.
2. Класс Hobbie должен наследоваться от интерфейсов Desire, Dream.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        System.out.println(Dream.HOBBIE.toString());
        System.out.println(new Hobbie().INDEX);
    }

    interface Desire
    {
    }

    interface Dream
    {
        static Hobbie HOBBIE = new Hobbie();
    }

    static class Hobbie implements Desire, Dream
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
