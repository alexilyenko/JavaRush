package com.javarush.test.level16.lesson13.home04;

/* Последовательные выполнения нитей
1. Разберись, что делает программа.
2. Сделай так, чтоб программа сначала выводила результат нити, а когда нить завершится - продолжила метод main.
3. Пример выходных данных:
inside MyThread 0
inside MyThread 1
...
inside MyThread 9
inside main 0
inside main 1
...
inside main 9
*/

import java.util.concurrent.TimeUnit;

class Solution {

  private static final MyThread t = new MyThread();
  private static final String message = "inside main ";

  public static void main(String a[]) throws Exception {
    t.start();
    t.join();
    for (int i = 0; i < 10; i++) {
      System.out.println(message + i);
      sleep();
    }
  }

  private static void sleep() {
    try {
      TimeUnit.MILLISECONDS.sleep(10);
    } catch (InterruptedException ignored) {
    }
  }

  static class MyThread extends Thread {

    final String message = "inside MyThread ";

    public void run() {
      for (int i = 0; i < 10; i++) {
        System.out.println(message + i);
        Solution.sleep();
      }
    }
  }
}
