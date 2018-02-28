package com.javarush.test.level12.lesson06.task01;

/* Абстрактный класс Pet
Сделать класс Pet абстрактным.
*/

class Solution {

  private static abstract class Pet {

    @SuppressWarnings("SameReturnValue")
    public String getName() {
      return "Я - котенок";
    }
  }

}
