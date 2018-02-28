package com.javarush.test.level09.lesson02.task05;

/* Метод должен возвращать результат – глубину её стек-трейса
Написать метод, который возвращает результат – глубину его стек трейса – количество методов в нем (количество элементов в списке). Это же число метод должен выводить на экран.
*/

class Solution {

  public static int getStackTraceDeep() {
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    int result = stackTraceElements.length;
    System.out.println(result);
    return result;
  }
}
