package com.javarush.test.level08.lesson03.task03;

import java.util.HashMap;
import java.util.Map;

/* Коллекция HashMap из котов
Есть класс Cat с полем имя (name, String).
Создать коллекцию HashMap<String, Cat>.
Добавить в коллекцию 10 котов, в качестве ключа использовать имя кота.
Вывести результат на экран, каждый элемент с новой строки.
*/

class Solution {

  public static void main(String[] args) {
    String[] cats = new String[]{"васька", "мурка", "дымка", "рыжик", "серый", "снежок", "босс",
        "борис", "визя", "гарфи"};
    HashMap<String, Cat> map = addCatsToMap(cats);

    for (Map.Entry<String, Cat> pair : map.entrySet()) {
      System.out.println(pair.getKey() + " - " + pair.getValue());
    }
  }


  private static HashMap<String, Cat> addCatsToMap(String[] cats) {
    HashMap<String, Cat> map = new HashMap<>();
    for (String cat : cats) {
      map.put(cat, new Cat(cat));
    }
    return map;
  }


  static class Cat {

    final String name;

    Cat(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return name != null ? name.toUpperCase() : null;
    }
  }
}
