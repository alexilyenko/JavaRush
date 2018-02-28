package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int maximum;
    int minimum;
    int[] mass = new int[20];

    for (int i = 0; i < mass.length; i++) {
      mass[i] = Integer.parseInt(reader.readLine());
    }

    maximum = mass[0];
    minimum = mass[0];

    for (int i = 1; i < mass.length; i++) {
      if (mass[i] > maximum) {
        maximum = mass[i];
      }
    }

    for (int i = 1; i < mass.length; i++) {
      if (mass[i] < minimum) {
        minimum = mass[i];
      }
    }

    System.out.print(maximum + " ");
    System.out.print(minimum);
  }
}
