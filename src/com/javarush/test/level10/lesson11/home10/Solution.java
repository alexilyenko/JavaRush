package com.javarush.test.level10.lesson11.home10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Пять наибольших чисел
Создать список целых чисел. Ввести с клавиатуры 20 целых чисел. Создать метод по безопасному извлечения чисел из списка:
int safeGetElement(ArrayList<Integer> list, int index, int defaultValue)
Метод должен возвращать элемент списка (list) по его индексу (index). Если в процессе получения элемента возникло исключение, его нужно перехватить, и метод должен вернуть defaultValue.
*/

class Solution {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      int x = Integer.parseInt(reader.readLine());
      list.add(x);
    }

    System.out.println(safeGetElement(list, 5, 1));
    System.out.println(safeGetElement(list, 20, 7));
    System.out.println(safeGetElement(list, -5, 9));
  }

  private static int safeGetElement(ArrayList<Integer> list, int index, int defaultValue) {
    int element;
    try {
      element = list.get(index);
    } catch (Exception ex) {
      element = defaultValue;
    }
    return element;
  }

}
