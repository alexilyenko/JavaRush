package com.javarush.test.level07.lesson12.home05;

/* Бум
Написать программу, которая ведёт обратный отсчёт с 30 до 0, и в конце выводит на экран текст «Бум!». Программа должна уменьшать число 10 раз в секунду. Для того чтобы вставить в программу задержку, воспользуйся функцией:
Thread.sleep(100); //задержка на одну десятую секунды.
Пример:
30
29
…
1
0
Бум!
*/

import java.util.concurrent.TimeUnit;

class Solution {

  public static void main(String[] args) throws InterruptedException {
    for (int i = 30; i >= 0; i--) {
      System.out.println(i);
      TimeUnit.MILLISECONDS.sleep(100);
    }
    System.out.println("Бум!");
  }
}
