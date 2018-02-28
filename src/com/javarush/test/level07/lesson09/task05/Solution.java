package com.javarush.test.level07.lesson09.task05;

import java.util.ArrayList;
import java.util.Scanner;

/* Удвой слова
1. Введи с клавиатуры 10 слов в список строк.
2. Метод doubleValues должен удваивать слова по принципу a,b,c -> a,a,b,b,c,c.
3. Используя цикл for выведи результат на экран, каждое значение с новой строки.
*/

class Solution {

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    for (int i = 0; i < 10; i++) {
      list.add(scan.nextLine());
    }
    ArrayList<String> result = doubleValues(list);

    for (String aResult : result) {
      System.out.println(aResult);
    }
  }

  private static ArrayList<String> doubleValues(ArrayList<String> list) {
    for (int i = 0; i < list.size(); ) {
      list.add(i + 1, list.get(i));
      i += 2;
    }
    return list;
  }
}
