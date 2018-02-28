package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

  private static Integer[] sort(Integer[] array) {
    Arrays.sort(array);
    final double median;
    if (array.length % 2 == 0) {
      median = ((double) array[array.length / 2 - 1] + (double) array[array.length / 2]) / 2;
    } else {
      median = array[array.length / 2];
    }
    Comparator<Integer> compareByMedian = (o1, o2) -> {
      double value = Math.abs(o1 - median) - Math.abs(o2 - median);
      if (value == 0) {
        value = o1 - o2;
      }
      return (int) value;
    };
    Arrays.sort(array, compareByMedian);
    System.out.println(median);
    return array;
  }

  public static void main(String[] args) {
    Integer[] mass = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(Arrays.toString(sort(mass)));
  }
}
