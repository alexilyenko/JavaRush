package com.javarush.test.level12.lesson12.home10;

/* Метод, который выводит на экран число 10
Добавь еще один метод, чтобы программа выводила на экран число 10.
Подсказка: используй перегрузку методов.
*/

class Solution {

  public static void main(String[] args) {
    Integer i = 5;
    int x = transformValue(i);

    System.out.println(x);
  }

  public static int transformValue(int i) {
    return i * i;
  }

  private static int transformValue(Integer i) {
    return i + i;
  }
}
