package com.javarush.test.level12.lesson12.bonus02;

/* Нужно добавить в программу новую функциональность
Сделать класс Pegas(пегас) на основе класса Horse(лошадь) и интерфейса Fly(летать).
*/

class Solution {

  public static void main(String[] args) {
    Pegas horse = new Pegas();
  }

  private interface Fly {

  }

  static class Horse {

  }

  private static class Pegas extends Horse implements Fly {

  }
}
