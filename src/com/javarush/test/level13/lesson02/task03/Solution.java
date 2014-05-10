package com.javarush.test.level13.lesson02.task03;

/* Пиво и кола
Реализуй интерфейс Drink в классах Beer и Cola.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        print(new Beer());
        print(new Cola());

    }

    private static void print(Drink drink)
    {
        System.out.println(drink.getClass().getSimpleName());
    }

    public interface Drink
    {
        boolean isAlcoholic();
    }

    public static class Beer implements Drink
    {
        public boolean isAlcoholic() {
            return true;
        }
    }

    public static class Cola implements Drink
    {
        public boolean isAlcoholic() {
            return false;
        }
    }
}
