package com.javarush.test.level08.lesson11.home04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Минимальное из N чисел
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.
*/

class Solution {

  public static void main(String[] args) throws Exception {
    List<Integer> integerList = getIntegerList();
    System.out.println(getMinimum(integerList));
  }

  private static int getMinimum(List<Integer> array) {
    int minimum = array.get(0);
    for (int i = 1; i < array.size(); i++) {
      if (array.get(i) < minimum) {
        minimum = array.get(i);
      }
    }
    return minimum;
  }

  private static List<Integer> getIntegerList() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int number = Integer.parseInt(reader.readLine());
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < number; i++) {
      list.add(Integer.parseInt(reader.readLine()));
    }
    return list;
  }
}
