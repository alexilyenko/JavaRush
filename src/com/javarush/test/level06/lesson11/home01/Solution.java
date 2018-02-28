package com.javarush.test.level06.lesson11.home01;

/* Класс Cat и статическая переменная catCount
В классе Cat создай статическую переменную public int catCount.
Создай конструктор [public Cat()]. Пусть при каждом создании кота (нового объекта Cat) статическая переменная
catCount увеличивается на 1. Создать 10 объектов Cat и вывести значение переменной catCount на экран.
*/

class Solution {

  public static void main(String[] args) {
    Cat cat1 = new Cat();
    Cat cat2 = new Cat();
    Cat cat3 = new Cat();
    Cat cat4 = new Cat();
    Cat cat5 = new Cat();
    Cat cat6 = new Cat();
    Cat cat7 = new Cat();
    Cat cat8 = new Cat();
    Cat cat9 = new Cat();
    Cat cat10 = new Cat();
    System.out.println(Cat.catCount);
  }

  static class Cat {

    static int catCount;

    Cat() {
      catCount++;
    }
  }

}
