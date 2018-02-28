package com.javarush.test.level09.lesson02.task03;

/* Метод должен вернуть номер строки кода, из которого вызвали этот метод
Написать пять методов, которые вызывают друг друга. Метод должен вернуть номер строки кода, из которого вызвали этот метод. Воспользуйся функцией: element.getLineNumber().
*/

@SuppressWarnings("UnusedReturnValue")
class Solution {

  public static void main(String[] args) {
    method1();
  }

  private static int method1() {
    method2();
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    return stackTraceElements[2].getLineNumber();
  }

  private static int method2() {
    method3();
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    return stackTraceElements[2].getLineNumber();
  }

  private static int method3() {
    method4();
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    return stackTraceElements[2].getLineNumber();
  }

  private static int method4() {
    method5();
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    return stackTraceElements[2].getLineNumber();
  }

  private static int method5() {
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    int num = stackTraceElements[2].getLineNumber();
    for (StackTraceElement element : stackTraceElements) {
      System.out.println(element.getMethodName());
    }
    return num;
  }
}
