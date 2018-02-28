package com.javarush.test.level08.lesson03.task04;

import java.util.HashMap;
import java.util.Map;

/* Вывести на экран список ключей
Есть коллекция HashMap<String, String>, туда занесли 10 различных строк. Вывести на экран список ключей, каждый элемент с новой строки.
*/

class Solution {

  public static void main(String[] args) {
    HashMap<String, String> map = new HashMap<>();
    map.put("Sim", "Sim");
    map.put("Tom", "Tom");
    map.put("Arbus", "Arbus");
    map.put("Baby", "Baby");
    map.put("Cat", "Cat");
    map.put("Dog", "Dog");
    map.put("Eat", "Eat");
    map.put("Food", "Food");
    map.put("Gevey", "Gevey");
    map.put("Hugs", "Hugs");
    printKeys(map);
  }

  private static void printKeys(Map<String, String> map) {
    for (Map.Entry<String, String> pair : map.entrySet()) {
      System.out.println(pair.getKey());
    }
  }
}
