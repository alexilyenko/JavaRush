package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

class Solution {

  public static void main(String[] args) {
    Map<String, Cat> map = createMap();
    Set<Cat> set = convertMapToSet(map);
    printCatSet(set);
  }

  private static Map<String, Cat> createMap() {
    Map<String, Cat> map = new HashMap<>();
    map.put("John", new Cat("John"));
    map.put("Nick", new Cat("Nick"));
    map.put("Michael", new Cat("Michael"));
    map.put("Phillip", new Cat("Phillip"));
    map.put("Ivan", new Cat("Ivan"));
    map.put("Alex", new Cat("Alex"));
    map.put("Brad", new Cat("Brad"));
    map.put("Kristine", new Cat("Kristine"));
    map.put("Penelopa", new Cat("Penelopa"));
    map.put("Mary", new Cat("Mary"));
    return map;
  }

  private static Set<Cat> convertMapToSet(Map<String, Cat> map) {
    Set<Cat> set = new HashSet<>();
    for (String s : map.keySet()) {
      set.add(map.get(s));
    }
    return set;
  }

  private static void printCatSet(Set<Cat> set) {
    for (Cat cat : set) {
      System.out.println(cat);
    }
  }

  static class Cat {

    private final String name;

    Cat(String name) {
      this.name = name;
    }

    public String toString() {
      return "Cat " + this.name;
    }
  }


}
