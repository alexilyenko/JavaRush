package com.javarush.test.level16.lesson13.home01;

/* Thread.currentThread - всегда возвращает текущую нить
1. В методе printMsg присвой переменной t текущую нить.
2. В методе printMsg после всех действий поставь задержку в 1 миллисекунду.
*/

class Solution {

  private static final int count = 5;

  public static void main(String[] args) {
    NameOfDifferentThreads tt = new NameOfDifferentThreads();
    tt.start();
    for (int i = 0; i < count; i++) {
      tt.printMsg();
    }
  }

  static class NameOfDifferentThreads extends Thread {

    public void run() {
      for (int i = 0; i < count; i++) {
        printMsg();
      }
    }

    void printMsg() {
      Thread t = Thread.currentThread();
      String name = t.getName();
      System.out.println("name=" + name);
      try {
        sleep(1);
      } catch (InterruptedException ignored) {
      }
    }
  }
}
