package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

class Solution {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int maximum = 0;
    String numberOfNumbers = reader.readLine();
    int numberOfNumbersInt = Integer.parseInt(numberOfNumbers);
    if (numberOfNumbersInt > 0) {
      for (int x = 0; x < numberOfNumbersInt; x++) {
        String number = reader.readLine();
        int numberInt = Integer.parseInt(number);
        if (numberInt > maximum) {
          maximum = numberInt;
        } else if (numberInt < 0 && maximum == 0) {
          maximum = numberInt;
        }
      }
      System.out.println(maximum);
    } else {
      System.out.println("Число должно быть больше 0!");
    }
  }
}
