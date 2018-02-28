package com.javarush.test.level15.lesson02.task01;

/* ООП - Расставить интерфейсы
1. Добавить все возможные интерфейсы из Movable, Sellable, Discountable в класс Clothes.
2. Реализовать их методы.
*/

public class Solution {

  public interface Movable {

    boolean getAllowedAction(String name);
  }

  interface Sellable {

    Object getAllowedAction(String name);
  }

  interface Discountable {

    Object getAllowedAction();
  }

  public static class Clothes implements Sellable, Discountable {

    public Object getAllowedAction(String name) {
      return this;
    }

    public Object getAllowedAction() {
      return this;
    }

  }
}
