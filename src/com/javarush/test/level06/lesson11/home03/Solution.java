package com.javarush.test.level06.lesson11.home03;

/* Переставь один модификатор static
Переставь один модификатор static, чтобы пример скомпилировался.
*/

class Solution {

  private static int A = 5;
  private final int B = 2;
  public int C = A * B;

  public static void main(String[] args) {
    A = 15;
  }
}

