package com.javarush.test.level04.lesson10.task01;

/* 10 чисел
Вывести на экран числа от 1 до 10 используя цикл while.
*/

class Solution {

  public static void main(String[] args) {
    int x = 1;
    while (x <= 10) {
      System.out.print(x + " ");
      x++;
    }
  }
}