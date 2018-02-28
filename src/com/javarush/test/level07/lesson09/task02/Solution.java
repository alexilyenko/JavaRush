package com.javarush.test.level07.lesson09.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


/* 5 слов в обратном порядке
Введи с клавиатуры 5 слов в список строк. Выведи их в обратном порядке.
*/

class Solution {

  public static void main(String[] args) throws Exception {
    BufferedReader readOn = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      String a = readOn.readLine();
      list.add(a);
    }

    for (int i = list.size() - 1; i >= 0; i--) {
      System.out.println(list.get(i));
    }
  }
}
