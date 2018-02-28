package com.javarush.test.level12.lesson06.task05;

/* Классы Cat и Dog от Pet
Унаследуй классы Cat и Dog от Pet.
Реализуй недостающие методы. Классы Cat и Dog не должны быть абстрактными.
*/

public class Solution {

  public static abstract class Pet {

    public abstract String getName();

    public abstract Pet getChild();
  }

  public static class Cat extends Pet {

    public String getName() {
      return "Cat!";
    }

    public Cat getChild() {
      return new Cat();
    }

  }

  public static class Dog extends Pet {

    public String getName() {
      return "Dog!";
    }

    public Dog getChild() {
      return new Dog();
    }

  }

}
