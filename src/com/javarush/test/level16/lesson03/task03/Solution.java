package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

class Solution {

  @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
  private static final List<Thread> list = new ArrayList<>();

  public static void main(String[] args) {
    list.add(new Thread(new SpecialThread()));
    list.add(new Thread(new SpecialThread()));
    list.add(new Thread(new SpecialThread()));
    list.add(new Thread(new SpecialThread()));
    list.add(new Thread(new SpecialThread()));
  }

  static class SpecialThread implements Runnable {

    public void run() {
      System.out.println("it's run method inside SpecialThread");
    }
  }
}
