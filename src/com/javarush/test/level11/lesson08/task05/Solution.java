package com.javarush.test.level11.lesson08.task05;

/* Добавь недостающие переменные
Посмотри внимательно на методы и добавь недостающие переменные.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Cat
    {
        private String name;
        private int age;
        private int weight;
        private int speed = 10;

        public Cat(String name, int age, int weight)
        {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        public String getName()
        {
            return  name;
        }

        public int getAge()
        {
            return age;
        }

        public void setWeight(int weight)
        {
           this.weight = weight;

        }

        public void setSpeed(int speed)
        {
            this.speed = speed;

        }
    }
}
