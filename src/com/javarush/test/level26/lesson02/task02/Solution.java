package com.javarush.test.level26.lesson02.task02;

import java.util.Set;
import java.util.TreeSet;

/* Был бы ум - будет и успех.
Солдаты всегда строились, строятся и будут строиться по убыванию роста.
Отсортируйте солдат, предварительно подумав, что лучше использовать при таких условиях - Comparable или Comparator.
*/
class Solution {

  public static void main(String[] args) {
    Set<Soldier> soldiers = new TreeSet<>();
    soldiers.add(new Soldier("Ivanov", 170));
    soldiers.add(new Soldier("Petrov", 180));
    soldiers.add(new Soldier("Sidorov", 175));

    for (Soldier soldier : soldiers) {
      System.out.println(soldier.name);
    }
  }

  static class Soldier implements Comparable<Soldier> {

    private final String name;
    private final int height;

    Soldier(String name, int height) {
      this.name = name;
      this.height = height;
    }

    @Override
    public int compareTo(Soldier o) {
      return o.height - this.height;
    }
  }
}
