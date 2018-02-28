package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int sum = 0;
    while (true) {
      String aString = reader.readLine();
      if (aString.equals("сумма")) {
        System.out.println(sum);
        break;
      } else {
        int a = Integer.parseInt(aString);
        sum = sum + a;
      }
    }
  }
}
