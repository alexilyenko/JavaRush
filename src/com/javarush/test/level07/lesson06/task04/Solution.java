package com.javarush.test.level07.lesson06.task04;

/* 5 строчек в начало списка
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры, но только добавлять не в конец списка, а в начало. 3.
3. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
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
