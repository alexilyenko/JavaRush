package com.javarush.test.level10.lesson11.home07;

/* Расставьте минимум static-ов
Расставьте как можно меньше модификаторов static так, чтобы пример скомпилировался.
*/

class Solution {

  private static int B = 5;
  private static int C = 5;
  private static int D = 5;
  private int A = 5;

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.A = 5;
    B = 5 * B;
    C = 5 * C * D;
    Solution.D = 5 * D * C;

    Solution.D = 5;
  }

  public int getA() {
    return A;
  }

}
