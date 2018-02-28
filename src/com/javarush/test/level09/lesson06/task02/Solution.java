package com.javarush.test.level09.lesson06.task02;

/* Исключение при работе со строками
Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
String s = null;
String m = s.toLowerCase();
*/

class Solution {

  @SuppressWarnings("ConstantConditions")
  public static void main(String[] args) {
    try {
      String s = null;
      String m = s.toLowerCase();
    } catch (NullPointerException e) {
      System.out.println(e.getMessage());
    }
  }
}
