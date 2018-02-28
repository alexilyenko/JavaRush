package com.javarush.test.level07.lesson12.home07;

/* Переставь один модификатор static
Переставь один модификатор static, чтобы пример скомпилировался.
*/

class Solution {

  private static final int A = 5;
  private static final int B = 2;
  private static final int C = A * B;

  @SuppressWarnings("SameReturnValue")
  public int getValue() {
    return C;
  }

}

