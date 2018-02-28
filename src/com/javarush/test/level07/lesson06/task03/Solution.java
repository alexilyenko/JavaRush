package com.javarush.test.level07.lesson06.task03;

/* 5 строчек в обратном порядке
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в него.
3. Расположи их в обратном порядке.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/

import java.util.ArrayList;
import java.util.Scanner;

class Solution {

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    for (int i = 0; i < 5; i++) {
      list.add(0, scan.nextLine());
    }
    for (String aList : list) {
      System.out.println(aList);
    }
  }
}
