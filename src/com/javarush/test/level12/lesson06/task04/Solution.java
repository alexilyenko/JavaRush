package com.javarush.test.level12.lesson06.task04;

/* Класс Cow от Animal
Унаследуй класс Cow от Animal.
Реализуй все недостающие методы в классе Cow.
*/

public class Solution {

  static abstract class Animal {

    @SuppressWarnings("SameReturnValue")
    public abstract String getName();
  }

  public static class Cow extends Animal {

    public String getName() {
      return "Hi!";
    }
  }

}
