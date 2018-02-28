package com.javarush.test.level25.lesson11.task02;

/* Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
Обеспечьте переуступку кванта времени для последовательных выводов текста в консоль
*/
class Solution {

  static class YieldRunnable implements Runnable {

    private final int index;

    public YieldRunnable(int index) {
      this.index = index;
    }

    public void run() {
      System.out.println("begin-" + index);
      Thread.yield();
      System.out.println("end-" + index);
    }
  }
}
