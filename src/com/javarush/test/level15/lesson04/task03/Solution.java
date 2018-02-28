package com.javarush.test.level15.lesson04.task03;

/* ООП - Перегрузка - убираем лишнее
1. Подумайте, какая из реализаций метода print будет вызвана.
2. Удалите все лишние реализации метода print.
*/

class Solution {

  public static void main(String[] args) {
    print(1);
  }

  private static void print(long l) {
    System.out.println("Я буду Java прогером!");
  }

}
