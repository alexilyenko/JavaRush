package com.javarush.test.level16.lesson07.task04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* Обратный отсчет
1. Разберись, что делает программа.
2. Реализуй логику метода printCountdown так, чтобы каждые полсекунды выводился объект из
переменной list в обратном порядке - от переданного индекса до нуля.
Пример: Передан индекс 3
Строка 2
Строка 1
Строка 0
*/

class Solution {

  private static final List<String> list = new ArrayList<>(5);

  static {
    for (int i = 0; i < 5; i++) {
      list.add("Строка " + i);
    }
  }

  public static void main(String[] args) {
    Thread t = new Thread(new Countdown(3));
    t.start();
  }

  static class Countdown implements Runnable {

    private int countFrom;

    Countdown(int countFrom) {
      this.countFrom = countFrom;
    }

    public void run() {
      try {
        while (countFrom > 0) {
          printCountdown();
        }
      } catch (InterruptedException ignored) {
      }
    }

    void printCountdown() throws InterruptedException {
      countFrom--;
      TimeUnit.MILLISECONDS.sleep(500);
      System.out.println(list.get(countFrom));
    }
  }
}
