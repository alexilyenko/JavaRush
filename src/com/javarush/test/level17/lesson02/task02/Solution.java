package com.javarush.test.level17.lesson02.task02;

import java.util.ArrayList;
import java.util.List;

/* Вместе быстрее? Ща проверим :)
1. Разберись, что и как работает
2. Создай public static нить SortThread, которая в методе run отсортирует статический массив testArray используя метод sort
*/

class Solution {

  private static final int countThreads = 10;
  private static final int[] testArray = new int[1000];

  static {
    for (int i = 0; i < Solution.testArray.length; i++) {
      testArray[i] = i;
    }
  }

  public static void main(String[] args) throws InterruptedException {
    initThreads();
  }

  private static void initThreads() throws InterruptedException {
    List<Thread> threads = new ArrayList<>(countThreads);
    for (int i = 0; i < countThreads; i++) {
      threads.add(new SortThread());
    }
    for (Thread thread : threads) {
      thread.start();
    }
    for (Thread thread : threads) {
      thread.join();
    }
  }

  private static void sort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] < array[j]) {
          int k = array[i];
          array[i] = array[j];
          array[j] = k;
        }
      }
    }
  }

  static class SortThread extends Thread {

    public void run() {
      sort(testArray);
    }
  }
}
