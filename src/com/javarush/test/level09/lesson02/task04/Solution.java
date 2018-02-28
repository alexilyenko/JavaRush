package com.javarush.test.level09.lesson02.task04;

/* Стек-трейс длиной 10 вызовов
Напиши код, чтобы получить стек-трейс длиной 10 вызовов.
*/

class Solution {

  public static void main(String[] args) {
    method1();
  }

  @SuppressWarnings("UnusedReturnValue")
  private static StackTraceElement[] method1() {
    return method2();
  }

  private static StackTraceElement[] method2() {
    return method3();
  }

  private static StackTraceElement[] method3() {
    return method4();
  }

  private static StackTraceElement[] method4() {
    return method5();
  }

  private static StackTraceElement[] method5() {
    return method6();
  }

  private static StackTraceElement[] method6() {
    return method7();
  }

  private static StackTraceElement[] method7() {
    return method8();
  }

  private static StackTraceElement[] method8() {
    return method9();
  }

  private static StackTraceElement[] method9() {
    return method10();
  }

  private static StackTraceElement[] method10() {
    return Thread.currentThread().getStackTrace();
  }
}
