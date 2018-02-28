package com.javarush.test.level06.lesson11.home07;

/* Три статические переменных name
Создай 3 public статических переменных: String Solution.name, String Cat.name, String Dog.name
*/

class Solution {

  public static String name;

  private static class Cat {

    public static String name;
  }

  private static class Dog {

    public static String name;
  }
}
