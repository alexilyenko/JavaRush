package com.javarush.test.level12.lesson02.task05;

/* Или «Корова», или «Кит», или «Собака», или «Неизвестное животное»
Написать метод, который определяет, объект какого класса ему передали, и возвращает результат – одно значение из: «Корова», «Кит», «Собака», «Неизвестное животное».
*/

class Solution {

  public static void main(String[] args) {
    System.out.println(getObjectType(new Cow()));
    System.out.println(getObjectType(new Dog()));
    System.out.println(getObjectType(new Whale()));
    System.out.println(getObjectType(new Pig()));
  }

  private static String getObjectType(Object o) {
    if (o instanceof Cow) {
      return "Корова";
    } else if (o instanceof Whale) {
      return "Кит";
    } else if (o instanceof Dog) {
      return "Собака";
    } else {
      return "Неизвестное животное";
    }
  }

  private static class Cow {

  }

  static class Dog {

  }

  private static class Whale {

  }

  private static class Pig {

  }
}
