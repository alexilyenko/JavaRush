package com.javarush.test.level16.lesson10.task04;

/* А без interrupt слабо?
Разберись, как работает программа.
Сделай так, чтобы в методе ourInterruptMethod можно было сделать так, чтобы нить TestThread завершилась сама.
Нельзя использовать метод interrupt.
*/

import java.util.concurrent.TimeUnit;

class Solution {

  public static void main(String[] args) throws InterruptedException {
    Thread t = new Thread(new TestThread());
    t.start();
    TimeUnit.SECONDS.sleep(3);
    ourInterruptMethod();
  }

  private static void ourInterruptMethod() {
    TestThread.cause = false;
  }

  static class TestThread implements Runnable {

    static boolean cause = true;

    public void run() {
      while (cause) {
        try {
          System.out.println("he-he");
          TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ignored) {
        }
      }
    }
  }
}
