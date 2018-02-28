package com.javarush.test.level09.lesson11.home07;

/* Расставь модификаторы static
Расставь модификаторы static так, чтобы пример скомпилировался.
*/

class Solution {

  private static int A = 5;
  private static final int B = 2 * A;
  private static int D = A * B;
  public int C = A * B;

  public void main(String[] args) {
    Solution room = new Solution();
    A = 5;

    Solution.D = 5;
  }

  public int getA() {
    return A;
  }

}
