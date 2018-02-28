package com.javarush.test.level08.lesson11.home07;

/* Переставь один модификатор static
Переставь один модификатор static, чтобы пример скомпилировался.
*/

class Solution {

  private static final int A = 5;
  private static final int B = 2;
  private static final int D = B * A;
  @SuppressWarnings("FieldCanBeLocal")
  private final int C = A * B;

  @SuppressWarnings("SameReturnValue")
  public int getValue() {
    return D;
  }

  public int getValue2() {
    return C;
  }
}

