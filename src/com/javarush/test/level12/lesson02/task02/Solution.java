package com.javarush.test.level12.lesson02.task02;

/* Ничего не выводится на экран
Переопределить метод getName в классе Whale(Кит), чтобы программа ничего не выдавала на экран.
*/

class Solution {

  public static void main(String[] args) {
    Cow cow = new Whale();

    System.out.println(cow.getName());
  }

  static class Cow {

    String getName() {
      return "Я - корова";
    }
  }

  static class Whale extends Cow {

    public String getName() {
      return "";
    }
  }
}
