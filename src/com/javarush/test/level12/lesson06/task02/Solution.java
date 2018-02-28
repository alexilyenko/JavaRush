package com.javarush.test.level12.lesson06.task02;

/* Исправь код. Первая задача
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
