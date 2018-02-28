package com.javarush.test.level10.lesson11.home02;

/* Правильный ответ: d=5.5
Добавить одну операцию по преобразованию типа, чтобы получался ответ: d=5.5.
*/

class Solution {

  public static void main(String[] args) {
    int a = 5;
    int b = 4;
    int c = 3;
    int e = 2;
    double d = a + (double) (b / c) / e;
    System.out.println(d);
  }
}
