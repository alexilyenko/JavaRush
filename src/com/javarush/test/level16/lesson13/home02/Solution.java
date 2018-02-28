package com.javarush.test.level16.lesson13.home02;

/* Последовательные выполнения нитей
1. В методе run после всех действий поставь задержку в 10 миллисекунд. Выведи "Нить прервана", если нить будет прервана.
2. Сделай так, чтобы все нити выполнялись последовательно: сначала для нити №1 отсчет с COUNT до 1, потом для нити №2 с COUNT до 1 и т.д.
Пример:
#1: 4
#1: 3
...
#1: 1
#2: 4
...
*/

import java.util.concurrent.TimeUnit;

class Solution {

  private final static int COUNT = 4;

  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < COUNT; i++) {
      new SleepingThread().join();
    }
  }

  static class SleepingThread extends Thread {

    private static volatile int threadCount = 0;
    private volatile int countDownIndex = COUNT;

    @SuppressWarnings("NonAtomicOperationOnVolatileField")
    SleepingThread() {
      super(String.valueOf(++threadCount));
      start();
    }

    @SuppressWarnings("NonAtomicOperationOnVolatileField")
    public void run() {
      while (true) {
        System.out.println(this);
        if (--countDownIndex == 0) {
          return;
        }
        try {
          TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
          System.out.println("Нить прервана");
        }
      }
    }

    public String toString() {
      return "#" + getName() + ": " + countDownIndex;
    }
  }
}
