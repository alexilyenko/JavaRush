package com.javarush.test.level06.lesson05.task03;

/* 10 000 объектов Cat и Dog
Создать в цикле 10 000 объектов Cat и Dog. (Java-машина должна начать уничтожать неиспользуемые, и метод finalize хоть раз да вызовется).
*/

class Solution {

  public static void main(String[] args) {
    for (int x = 0; x < 10000; x++) {
      Cat cat = new Cat();
      Dog dog = new Dog();
    }

  }
}

class Cat {

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println("Cat destroyed");
  }
}

class Dog {

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println("Dog destroyed");
  }
}