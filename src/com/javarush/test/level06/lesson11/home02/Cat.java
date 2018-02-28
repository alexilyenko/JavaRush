package com.javarush.test.level06.lesson11.home02;

import java.util.ArrayList;

/* Статические коты
1. В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.
*/

class Cat {

  private static final ArrayList<Cat> cats = new ArrayList<>();

  private Cat() {
    cats.add(this);
  }

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      new Cat();
    }
    printCats();
  }

  private static void printCats() {
    for (Cat cat : cats) {
      System.out.println(cat);
    }
  }
}