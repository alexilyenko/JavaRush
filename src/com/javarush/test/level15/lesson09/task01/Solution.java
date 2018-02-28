package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

class Solution {

  private static final Map<Double, String> labels = new HashMap<>();

  static {
    labels.put(1d, "1");
    labels.put(2d, "2");
    labels.put(3d, "3");
    labels.put(4d, "4");
    labels.put(5d, "5");
  }

  public static void main(String[] args) {
    System.out.println(labels);
  }
}
