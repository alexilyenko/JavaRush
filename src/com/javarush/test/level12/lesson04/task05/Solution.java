package com.javarush.test.level12.lesson04.task05;

/* Три метода возвращают максимальное из двух переданных в него чисел
Написать public static методы: int max(int, int), long max (long, long), double max (double, double).
Каждый метод должен возвращать максимальное из двух переданных в него чисел.
*/

class Solution {

  public static int max(int a, int b) {
    if (a < b) {
      return b;
    } else {
      return a;
    }
  }

  public static long max(long a, long b) {
    if (a < b) {
      return b;
    } else {
      return a;
    }
  }

  public static double max(double a, double b) {
    if (a < b) {
      return b;
    } else {
      return a;
    }
  }
}
