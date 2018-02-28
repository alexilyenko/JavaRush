package com.javarush.test.level16.lesson03.task04;

/* Вывод стек-трейса
1. Создать таск - класс public static SpecialThread - на основании интерфейса Runnable
2. SpecialThread должен выводить в консоль свой стек-трейс.
Подсказка: main thread уже выводит в консоль свой стек-трейс.
*/

class Solution {

  public static void main(String[] args) {
    Thread thread = new Thread(new SpecialThread());
    thread.start();

    System.out.println("*****************");

    for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
      System.out.println(element);
    }
  }

  static class SpecialThread implements Runnable {

    public void run() {
      for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
        System.out.println(element);
      }
    }
  }
}
