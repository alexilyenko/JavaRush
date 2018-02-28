package com.javarush.test.level09.lesson06.task04;

import java.util.ArrayList;
import java.util.List;

/* Исключение при работе с коллекциями List
Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
ArrayList<String> list = new ArrayList<String>();
String s = list.get(18);
*/

class Solution {

  @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
  public static void main(String[] args) {
    try {
      List<String> list = new ArrayList<>();
      String s = list.get(18);
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    }
  }
}
