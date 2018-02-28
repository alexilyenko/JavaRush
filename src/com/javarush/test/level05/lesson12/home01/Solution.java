package com.javarush.test.level05.lesson12.home01;

/* Три класса
По аналогии с классом Duck(утка) создай классы Cat(кошка) и Dog(собака).
Подумай, что должен возвращать метод toString в классах Cat и Dog?
В методе main создай по два объекта каждого класса и выведите их на экран.
Объекты класса Duck уже созданы и выводятся на экран.
*/

class Solution {

  public static void main(String[] args) {
    Duck duck1 = new Duck();
    Duck duck2 = new Duck();
    System.out.println(duck1);
    System.out.println(duck2);
    Dog dog1 = new Dog();
    Dog dog2 = new Dog();
    System.out.println(dog1);
    System.out.println(dog2);
    Cat cat1 = new Cat();
    Cat cat2 = new Cat();
    System.out.println(cat1);
    System.out.println(cat2);
  }

  static class Duck {

    public String toString() {
      return "Duck";
    }
  }

  static class Dog {

    public String toString() {
      return "Dog";
    }
  }

  static class Cat {

    public String toString() {
      return "Cat";
    }
  }
}
