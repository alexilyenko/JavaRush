package com.javarush.test.level15.lesson04.task04;

/* Мужчина или женщина?
1. В методе main создать 2 человека man и woman. man с типом Man, woman с типом Woman.
2. Изменить метод printName так, чтобы он выполнялся для man и woman.
3. Реализация метода printName должна быть одна.
*/

class Solution {

  public static void main(String[] args) {
    Human man = new Man();
    Human woman = new Woman();

    printName(man);
    printName(woman);
  }

  @SuppressWarnings("EmptyMethod")
  private static void printName(Human human) {

  }

  static class Human {

  }

  private static class Man extends Human {

  }

  private static class Woman extends Human {

  }
}
