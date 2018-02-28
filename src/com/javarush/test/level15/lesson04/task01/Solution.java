package com.javarush.test.level15.lesson04.task01;

/* Что-то лишнее
1. Программа должна выводить следующее:
Это double
Это Object
Это double
Это Integer
Это double

2 Удалите реализации всех лишних методов
*/

class Solution {

  public static void main(String[] args) {
    print((short) 1);
    print((Number) 1);
    print(1);
    print((Integer) 1);
    print(1);
  }

  private static void print(Integer i) {
    System.out.println("Это Integer");
  }

  private static void print(Object i) {
    System.out.println("Это Object");
  }

  private static void print(double i) {
    System.out.println("Это double");
  }


}
