package com.javarush.test.level13.lesson02.task05;

/* 4 ошибки
Исправь 4 ошибки в программе, чтобы она компилировалась.
*/

public class Solution {

  public static void main(String[] args) {

    new Hobbie();
    System.out.println(Dream.HOBBIE.toString());
    System.out.println(new Hobbie().toString());

  }

  private interface Desire {

  }

  interface Dream {

    Hobbie HOBBIE = new Hobbie();
  }

  static class Hobbie implements Dream, Desire {

    static int INDEX = 1;

    @Override
    public String toString() {
      INDEX++;
      return "" + INDEX;
    }
  }

}
