package com.javarush.test.level14.lesson02.task02;

/* Bingo-2
Исправь строчку 'Cat o = new Cat();' так, чтобы программа вывела "Bingo!"
*/

class Solution {

  public static void main(String[] args) {
    Cat o = new TomCat();

    //noinspection ConstantConditions
    boolean isCat = o instanceof Cat;
    //noinspection ConstantConditions
    boolean isMoveable = o instanceof Moveable;
    //noinspection ConstantConditions
    boolean isTom = o instanceof TomCat;

    //noinspection ConstantConditions
    if (isCat && isMoveable && isTom) {
      System.out.println("Bingo!");
    }

  }

  private interface Moveable {

  }

  static class Cat {

  }

  private static class TomCat extends Cat implements Moveable {

  }
}
