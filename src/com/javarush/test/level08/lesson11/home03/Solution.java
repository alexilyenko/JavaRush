package com.javarush.test.level08.lesson11.home03;

import java.util.HashMap;
import java.util.Map;

/* Люди с одинаковыми именами и/или фамилиями
1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде «Фамилия»-«Имя».
2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями.
4. Вывести содержимое Map на экран.
*/

class Solution {

  public static void main(String[] args) {
    Map<String, String> map = createPeopleList();
    printPeopleList(map);
  }

  @SuppressWarnings("OverwrittenKey")
  private static Map<String, String> createPeopleList() {
    Map<String, String> map = new HashMap<>();
    map.put("Горбачев", "Алексей");
    map.put("Чудинов", "Константин");
    map.put("Санников", "Евгений");
    map.put("Рыбцов", "Сергей");
    map.put("Рогачев", "Василий");
    map.put("Чудинов", "Денис");
    map.put("Скосырских", "Александра");
    map.put("Пузина", "Елизавета");
    map.put("Ерепанов", "Денис");
    map.put("Табулды", "Константин");
    return map;
  }

  private static void printPeopleList(Map<String, String> map) {
    for (Map.Entry<String, String> s : map.entrySet()) {
      System.out.println(s.getKey() + " " + s.getValue());
    }
  }
}
