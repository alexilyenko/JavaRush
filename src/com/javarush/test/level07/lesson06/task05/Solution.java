package com.javarush.test.level07.lesson06.task05;

/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/

import java.util.ArrayList;
import java.util.Scanner;

class Solution {

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    for (int i = 0; i < 5; i++) {
      list.add(scan.nextLine());
    }
    for (int i = 0; i < 13; i++) {
      String s = list.get(list.size() - 1);
      list.remove(list.size() - 1);
      list.add(0, s);
    }
    for (String aList : list) {
      System.out.println(aList);
    }
  }
}
