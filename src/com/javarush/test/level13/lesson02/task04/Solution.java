package com.javarush.test.level13.lesson02.task04;

/* Selectable и Updatable
1. Создай класс Screen.
2. Реализуй в нем интерфейсы Selectable с методом onSelect, Updatable с методом refresh.
*/

public class Solution {

  interface Selectable {

    void onSelect();
  }

  interface Updatable {

    void refresh();
  }

  public class Screen implements Selectable, Updatable {

    public void onSelect() {
      System.out.println("On select!");
    }

    public void refresh() {
      System.out.println("Refreshing!");
    }
  }

}
