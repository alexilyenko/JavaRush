package com.javarush.test.level15.lesson09.task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Статики 2
1. В статическом блоке считайте две переменные с консоли А и В с типом int.
2. Не забыть про IOException, который надо обработать в блоке catch.
3. Закрыть поток ввода методом close().
*/

class Solution {

  @SuppressWarnings("CanBeFinal")
  private static int A;
  @SuppressWarnings("CanBeFinal")
  private static int B;
  private static final int MIN = min(A, B);

  static {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    try {
      A = Integer.parseInt(reader.readLine());
      B = Integer.parseInt(reader.readLine());
      reader.close();
    } catch (IOException ignored) {
    }
  }

  public static void main(String[] args) {
    System.out.println(MIN);
  }

  private static int min(int a, int b) {
    return a < b ? a : b;
  }
}
