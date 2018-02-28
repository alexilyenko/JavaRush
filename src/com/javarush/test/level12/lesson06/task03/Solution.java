package com.javarush.test.level12.lesson06.task03;

/* Исправь код. Вторая задача
Исправь код, чтобы программа компилировалась.
*/

public class Solution {

  public static abstract class Pet {

    @SuppressWarnings("SameReturnValue")
    public String getName() {
      return "Я - котенок";
    }

    public abstract Pet getChild();
  }

}
