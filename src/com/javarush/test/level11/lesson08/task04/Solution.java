package com.javarush.test.level11.lesson08.task04;

/* Инкапсуляция для классов Cat и Dog
Скрыть все внутренние переменные класса Cat и Dog. Также скрыть все методы, кроме тех, с помощью которых эти классы взаимодействуют друг с другом.
*/

class Solution {

  public static void main(String[] args) {
    Cat cat = new Cat("Vaska", 5);
    Dog dog = new Dog("Sharik", 4);

    cat.isDogNear(dog);
    dog.isCatNear(cat);
  }

  static class Cat {

    private final String name;
    private final int speed;

    Cat(String name, int speed) {
      this.name = name;
      this.speed = speed;
    }

    private String getName() {
      return name;
    }

    private int getSpeed() {
      return speed;
    }

    @SuppressWarnings("UnusedReturnValue")
    boolean isDogNear(Dog dog) {
      return this.speed > dog.getSpeed();
    }
  }

  static class Dog {

    private final String name;
    private final int speed;

    Dog(String name, int speed) {
      this.name = name;
      this.speed = speed;
    }

    private String getName() {
      return name;
    }

    private int getSpeed() {
      return speed;
    }

    @SuppressWarnings("UnusedReturnValue")
    boolean isCatNear(Cat cat) {
      return this.speed > cat.getSpeed();
    }
  }
}
