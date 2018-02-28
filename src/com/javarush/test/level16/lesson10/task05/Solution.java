package com.javarush.test.level16.lesson10.task05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* Один для всех, все - для одного
1. Разберись, как работает программа.
1.1. Обрати внимание, что объект Water - один для всех нитей.

2. Реализуй метод ourInterruptMethod, чтобы он прерывал все нити из threads.
3. В методе run исправь значения переменных:
3.1. isCurrentThreadInterrupted - должна равняться значению метода isInterrupted у текущей нити.
3.2. threadName - должна равняться значению метода getName (реализовано в классе Thread) у текущей нити.
*/

class Solution {

  private static final byte countThreads = 3;
  private static final List<Thread> threads = new ArrayList<>(countThreads);

  public static void main(String[] args) throws InterruptedException {
    initThreadsAndStart();
    TimeUnit.SECONDS.sleep(3);
    ourInterruptMethod();
  }

  private static void ourInterruptMethod() {
    for (Thread thread : threads) {
      thread.interrupt();
    }
  }

  private static void initThreadsAndStart() {
    Water water = new Water("water");
    for (int i = 0; i < countThreads; i++) {
      threads.add(new Thread(water, "#" + i));
    }

    for (int i = 0; i < countThreads; i++) {
      threads.get(i).start();
    }
  }

  static class Water implements Runnable {

    private final String commonResource;

    Water(String commonResource) {
      this.commonResource = commonResource;
    }

    public void run() {
      Thread current = Thread.currentThread();
      boolean isCurrentThreadInterrupted = current.isInterrupted();
      String threadName = current.getName();

      try {
        while (!isCurrentThreadInterrupted) {

          System.out.println("Объект " + commonResource + ", нить " + threadName);
          TimeUnit.SECONDS.sleep(1);
        }
      } catch (InterruptedException ignored) {
      }
    }
  }
}
