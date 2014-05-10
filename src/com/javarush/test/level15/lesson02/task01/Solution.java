package com.javarush.test.level15.lesson02.task01;

/* ООП - Расставить интерфейсы
1. Добавить все возможные интерфейсы из Movable, Sellable, Discountable в класс Clothes.
2. Реализовать их методы.
*/

public class Solution
{
    public static interface Movable
    {
        boolean getAllowedAction(String name);
    }

    public static interface Sellable
    {
        Object getAllowedAction(String name);
    }

    public static interface Discountable
    {
        Object getAllowedAction();
    }

    public static class Clothes implements Sellable, Discountable
    {

        public Object getAllowedAction(String name)
        {
            return this;
        }

        public Object getAllowedAction()
        {
            return this;
        }

    }
}
