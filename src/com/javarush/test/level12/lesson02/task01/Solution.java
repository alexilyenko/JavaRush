package com.javarush.test.level12.lesson02.task01;

/* Я не корова, Я - кит.
Переопределить метод getName в классе Whale(Кит), чтобы программа выдавала:
Я не корова, Я - кит.
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
      return "Я не корова, Я - кит.";
    }

  }
}
