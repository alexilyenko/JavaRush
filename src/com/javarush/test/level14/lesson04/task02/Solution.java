package com.javarush.test.level14.lesson04.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Коты
1. Считывать строки(параметры) с консоли, пока пользователь не введет пустую строку(Enter).
2. Каждый параметр соответствует имени кота.
Для каждого параметра:
3. Создать объект cat класса Cat, который равен коту из getCatByKey(String параметр).
4. Вывести на экран cat.toString().
*/

public class Solution {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<Cat> list = new ArrayList<>();
    while (true) {
      String currentCat = reader.readLine();
      if (currentCat.equals("")) {
        break;
      }
      Cat cat = CatFactory.getCatByKey(currentCat);
      list.add(cat);
    }
    for (Cat i : list) {
      System.out.println(i);
    }
  }

  static class CatFactory {

    static Cat getCatByKey(String key) {
      Cat cat;
      switch (key) {
        case "vaska":
          cat = new MaleCat("Василий");
          break;
        case "murka":
          cat = new FemaleCat("Мурочка");
          break;
        case "kiska":
          cat = new FemaleCat("Кисюлька");
          break;
        default:
          cat = new Cat(key);
          break;
      }

      return cat;
    }
  }

  static class Cat {

    private final String name;

    Cat(String name) {
      this.name = name;
    }

    String getName() {
      return this.name;
    }

    public String toString() {
      return "Я уличный кот " + getName();
    }
  }

  static class MaleCat extends Cat {

    @SuppressWarnings("SameParameterValue")
    MaleCat(String name) {
      super(name);
    }

    public String toString() {
      return "Я - солидный кошак по имени " + getName();
    }
  }

  static class FemaleCat extends Cat {

    FemaleCat(String name) {
      super(name);
    }

    public String toString() {
      return "Я - милая кошечка по имени " + getName();
    }
  }
}
