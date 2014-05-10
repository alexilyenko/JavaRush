package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12/*высота, см*/ /*длина хвоста, см */


public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);
        Dog spykeDog = new Dog("Spyke", 100, 99);
        Cat tomCat = new Cat("Tom", 50, 99);
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }
    public static class Cat
    {
        String name;
        int height;
        int evil;

        public Cat(String name, int height, int evil)
        {
            this.name = name;
            this.height = height;
            this.evil = evil;
        }
    }
    public static class Dog
    {
        String name;
        int height;
        int strength;

        public Dog(String name, int height, int strength)
        {
            this.name = name;
            this.height = height;
            this.strength = strength;
        }
    }
}
