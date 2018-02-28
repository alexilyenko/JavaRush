package com.javarush.test.level12.lesson12.bonus03;

/* Задача по алгоритмам
Написать метод, который возвращает минимальное число в массиве и его позицию (индекс).
*/

import java.util.Arrays;

class Solution {

  public static void main(String[] args) {
    int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

    Pair<Integer, Integer> result = getMinimumAndIndex(data);

    System.out.println("Minimum is " + result.x);
    System.out.println("Index of minimum element is " + result.y);
  }

  @SuppressWarnings("Duplicates")
  private static Pair<Integer, Integer> getMinimumAndIndex(int[] array) {
    if (array == null || array.length == 0) {
      return new Pair<>(null, null);
    }

    int[] b = Arrays.copyOf(array, array.length);

    for (int i = 0; i < array.length; i++) {
      for (int j = array.length - 1; j > i; j--) {
        if (array[j] < array[j - 1]) {
          int temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
        }
      }
    }

    int position = 0;

    for (int i = 0; i < b.length; i++) {
      if (b[i] == array[0]) {
        position = i;
        break;
      }
    }

    return new Pair<>(array[0], position);
  }


  static class Pair<X, Y> {

    final X x;
    final Y y;

    Pair(X x, Y y) {
      this.x = x;
      this.y = y;
    }
  }
}
