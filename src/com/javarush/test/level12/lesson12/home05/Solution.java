package com.javarush.test.level12.lesson12.home05;

/* Что это? «Кот», «Тигр», «Лев», «Бык», «Корова», «Животное»
Напиши метод, который определяет, какой объект передали в него.
Программа должна выводить на экран одну из надписей:
«Кот», «Тигр», «Лев», «Бык», «Корова», «Животное».
Замечание: постарайся определять тип животного как можно более точно.
*/

class Solution {

  public static void main(String[] args) {
    System.out.println(getObjectType(new Cat()));
    System.out.println(getObjectType(new Tiger()));
    System.out.println(getObjectType(new Lion()));
    System.out.println(getObjectType(new Bull()));
    System.out.println(getObjectType(new Cow()));
    System.out.println(getObjectType(new Animal()));
  }

  private static String getObjectType(Object o) {
    if (o instanceof Tiger) {
      return "Тигр";
    } else if (o instanceof Lion) {
      return "Лев";
    } else if (o instanceof Cat) {
      return "Кот";
    } else if (o instanceof Bull) {
      return "Бык";
    } else if (o instanceof Cow) {
      return "Корова";
    } else if (o instanceof Animal) {
      return "Животное";
    } else {
      return "хз";
    }
  }

  static class Cat extends Animal   //<--Классы наследуются!!
  {

  }

  private static class Tiger extends Cat {

  }

  private static class Lion extends Cat {

  }

  private static class Bull extends Animal {

  }

  private static class Cow extends Animal {

  }

  static class Animal {

  }
}
