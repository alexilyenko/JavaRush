package com.javarush.test.level11.lesson11.bonus03;

/* Задача по алгоритмам
Написать метод, который возвращает минимальное и максимальное числа в массиве.
*/

class Solution {

  public static void main(String[] args) {
    int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

    Pair<Integer, Integer> result = getMinimumAndMaximum(data);

    System.out.println("Minimum is " + result.x);
    System.out.println("Maximum is " + result.y);
  }

  @SuppressWarnings("Duplicates")
  private static Pair<Integer, Integer> getMinimumAndMaximum(int[] array) {
    if (array == null || array.length == 0) {
      return new Pair<>(null, null);
    }

    for (int i = 0; i < array.length; i++) {
      for (int j = array.length - 1; j > i; j--) {
        if (array[j] < array[j - 1]) {
          int temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
        }
      }
    }

    return new Pair<>(array[0], array[array.length - 1]);
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
