package com.javarush.test.level16.lesson07.task01;

/* Часы
1. Разберись, что делает программа.
2. Реализуйте логику метода printTikTak:
2.1. Через первые полсекунды должна выводиться в консоль фраза: Tik.
2.2. Через вторые полсекунды должна выводиться в консоль фраза: Tak.
*/

import java.util.concurrent.TimeUnit;

class Solution {

  private static volatile boolean isStopped = false;

  public static void main(String[] args) throws InterruptedException {
    Clock clock = new Clock();
    TimeUnit.SECONDS.sleep(2);
    isStopped = true;
    System.out.println("Clock has to be stopped");
    TimeUnit.SECONDS.sleep(1);
    System.out.println("Double-check");
  }

  static class Clock extends Thread {

    Clock() {
      setPriority(MAX_PRIORITY);
      start();
    }

    public void run() {
      try {
        while (!isStopped) {
          printTikTak();
        }
      } catch (InterruptedException ignored) {
      }
    }

    private void printTikTak() throws InterruptedException {
      TimeUnit.MILLISECONDS.sleep(500);
      System.out.println("Tik.");
      TimeUnit.MILLISECONDS.sleep(500);
      System.out.println("Tak.");
    }
  }
}
