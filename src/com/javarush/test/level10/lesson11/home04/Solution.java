package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

class Solution {

  public static void main(String[] args) {
    String s = "Я не хочу изучать Java, я хочу большую зарплату";
    char[] doNotWant = s.toCharArray();
    for (int i = 0; i < 40; i++) {
      for (int j = i; j < doNotWant.length; j++) {
        System.out.print(doNotWant[j]);
      }
      System.out.println();
    }

  }

}
