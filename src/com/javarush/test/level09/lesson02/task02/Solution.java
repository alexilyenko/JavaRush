package com.javarush.test.level09.lesson02.task02;

/* И снова StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать имя метода, вызвавшего его, полученное с помощью StackTrace.
*/

@SuppressWarnings("UnusedReturnValue")
class Solution {

  public static void main(String[] args) {
    System.out.println(method1());
  }

  private static String method1() {
    method2();
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    String name = stackTraceElements[2].getMethodName();
    System.out.println(name);
    return name;
  }

  private static String method2() {
    method3();
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    String name = stackTraceElements[2].getMethodName();
    System.out.println(name);
    return name;
  }

  private static String method3() {
    method4();
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    String name = stackTraceElements[2].getMethodName();
    System.out.println(name);
    return name;
  }

  private static String method4() {
    method5();
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    String name = stackTraceElements[2].getMethodName();
    System.out.println(name);
    return name;
  }

  private static String method5() {
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    String name = stackTraceElements[2].getMethodName();
    System.out.println(name);
    return name;
  }
}
