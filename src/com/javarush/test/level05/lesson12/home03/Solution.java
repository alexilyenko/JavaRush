package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12/*высота, см*/ /*длина хвоста, см */


class Solution {

  public static void main(String[] args) {
    Mouse jerryMouse = new Mouse("Jerry", 12, 5);
    Dog spykeDog = new Dog("Spyke", 100, 99);
    Cat tomCat = new Cat("Tom", 50, 99);
  }

  static class Mouse {

    final String name;
    final int height;
    final int tail;

    Mouse(String name, int height, int tail) {
      this.name = name;
      this.height = height;
      this.tail = tail;
    }
  }

  static class Cat {

    final String name;
    final int height;
    final int evil;

    Cat(String name, int height, int evil) {
      this.name = name;
      this.height = height;
      this.evil = evil;
    }
  }

  static class Dog {

    final String name;
    final int height;
    final int strength;

    Dog(String name, int height, int strength) {
      this.name = name;
      this.height = height;
      this.strength = strength;
    }
  }
}
