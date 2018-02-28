package com.javarush.test.level20.lesson07.task01;

import java.util.Arrays;

/**
 * Created by Алексей on 26.04.2014.
 */
class Haha {

  public static void main(String[] args) {
    int[] numbers = new int[]{5, 8, 4, 3, 6, 6, 3, 7};
    int[] sorted = sort(numbers);
    System.out.println(Arrays.toString(sorted));
  }

  private static int[] sort(int[] a) {
    if (a.length == 1) {
      return a;
    }

    int middle = a.length / 2;
    int[] left = new int[middle];
    int[] right = new int[a.length - middle];

    for (int i = 0; i < a.length; i++) {
      if (i < middle) {
        left[i] = a[i];
      } else {
        right[i - middle] = a[i];
      }
    }

    return merge(sort(left), sort(right));
  }

  private static int[] merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];

    int i = 0, j = 0, k = 0;

    while (k < result.length) {
      if (i == left.length) {
        result[k] = right[j];
        j++;
      } else if (j == right.length) {
        result[k] = left[i];
        i++;
      } else {
        if (left[i] < right[j]) {
          result[k] = left[i];
          i++;
        } else {
          result[k] = right[j];
          j++;
        }
      }
      k++;
    }

    return result;
  }
}
