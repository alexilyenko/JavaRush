package com.javarush.test.level08.lesson08.task02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

class Solution {

  public static void main(String[] args) {
    HashSet<Integer> set = createSet();
    removeAllNumbersMoreThen10(set);
  }

  private static HashSet<Integer> createSet() {
    HashSet<Integer> set = new HashSet<>();
    Random rand = new Random();
    for (int i = 0; i < 20; i++) {
      set.add(rand.nextInt());
    }
    return set;
  }

  @SuppressWarnings("UnusedReturnValue")
  private static HashSet<Integer> removeAllNumbersMoreThen10(HashSet<Integer> set) {
    ArrayList<Integer> aList = new ArrayList<>(set);
    for (int i = 0; i < aList.size(); i++) {
      if (aList.get(i) > 10) {
        aList.remove(i);
        i--;
      }
    }
    return new HashSet<>(aList);
  }
}
