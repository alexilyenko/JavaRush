package com.javarush.test.level09.lesson11.home02;

/* Обратный отсчёт от 10 до 0
Написать в цикле обратный отсчёт от 10 до 0. Для задержки иcпользовать Thread.sleep(100);
Обернуть вызов sleep в try..catch.
*/

import java.util.concurrent.TimeUnit;

class Solution {

  public static void main(String[] args) {
    for (int i = 10; i >= 0; i--) {
      System.out.println(i);
      try {
        TimeUnit.MILLISECONDS.sleep(100);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
