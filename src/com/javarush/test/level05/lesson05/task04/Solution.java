package com.javarush.test.level05.lesson05.task04;

/* Создать три объекта типа Cat
В методе main создать три объекта типа Cat и заполнить их данными.
Использовать класс Cat из первой задачи. Класс Cat создавать не надо.
*/

class Solution {

  public static void main(String[] args) {
    Cat cat1 = new Cat("Vaska", 1, 25, 5);
    Cat cat2 = new Cat("Petka", 2, 34, 4);
    Cat cat3 = new Cat("Mashka", 1, 18, 1);
  }

  static class Cat {

    static int count = 0;
    private final String name;
    private final int age;
    private final int weight;
    private final int strength;

    Cat(String name, int age, int weight, int strength) {
      count++;
      this.name = name;
      this.age = age;
      this.weight = weight;
      this.strength = strength;
    }
  }
}
