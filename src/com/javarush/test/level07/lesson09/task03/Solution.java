package com.javarush.test.level07.lesson09.task03;

import java.util.ArrayList;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

class Solution {

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("мама");
    list.add("мыла");
    list.add("раму");
    String s = "именно";
    list.add(1, s);
    list.add(3, s);
    list.add(5, s);
    for (String aList : list) {
      System.out.println(aList);
    }
  }
}
