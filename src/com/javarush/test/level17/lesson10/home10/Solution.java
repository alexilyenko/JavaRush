package com.javarush.test.level17.lesson10.home10;

/* Посчитаем
1. Сделай так, чтобы результат успел посчитаться для всех элементов массива values НЕ используя Thread.sleep
2. Исправь synchronized блок так, чтобы программа не вывела результат на экран
*/

class Solution {

  private static final int[] values = new int[105];
  private static Integer count = 0;

  static {
    for (int i = 0; i < 105; i++) {
      values[i] = 0;
    }
  }

  public static void main(String[] args) {
    Counter counter1 = new Counter();
    Counter counter2 = new Counter();
    Counter counter3 = new Counter();
    Counter counter4 = new Counter();

    counter1.start();
    counter2.start();
    counter3.start();
    counter4.start();

    for (int i = 1; i <= 100; i++) {
      if (values[i] > 1) {
        System.out.println(String.format("%d повторилось %d раз", i, values[i]));
      } else if (values[i] == 0) {
        System.out.println(String.format("%d ни разу не встретилось", i));
      }
    }
  }

  private static void incrementCount() {
    count++;
  }

  private static int getCount() {
    return count;
  }

  static class Counter extends Thread {

    @Override
    public void run() {
      synchronized (this) {
        while (getCount() < 100) {
          incrementCount();
          values[getCount()]++;
        }
      }
      try {
        Thread.sleep(1);
      } catch (InterruptedException ignored) {
      }
    }
  }
}

