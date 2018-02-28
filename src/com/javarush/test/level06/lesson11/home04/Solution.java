package com.javarush.test.level06.lesson11.home04;

/* Мама мыла раму или наоборот
Расставьте минимальное количество static-ов, чтобы код начал работать, и программа успешно завершилась
*/

class Solution {

  private static int step;

  public static void main(String[] args) {
    method1();
  }

  private static void method1() {
    method2();
  }

  private static void method2() {
    new Solution().method3();
  }

  private void method3() {
    method4();
  }

  private void method4() {
    step++;
    for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
      System.out.println(element);
    }
    if (step > 1) {
      return;
    }
    main(null);
  }
}
