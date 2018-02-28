package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;
import java.util.Random;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

class Solution {

  public static void main(String[] args) {
    ArrayList<int[]> list = createList();
    printList(list);
  }

  private static ArrayList<int[]> createList() {
    ArrayList<int[]> list = new ArrayList<>();
    Random rand = new Random();
    int[] a = new int[5];
    for (int i = 0; i < a.length; i++) {
      a[i] = rand.nextInt(10000);
    }
    list.add(a);
    int[] b = new int[2];
    for (int i = 0; i < b.length; i++) {
      b[i] = rand.nextInt(10000);
    }
    list.add(b);
    int[] c = new int[4];
    for (int i = 0; i < c.length; i++) {
      c[i] = rand.nextInt(10000);
    }
    list.add(c);
    int[] d = new int[7];
    for (int i = 0; i < d.length; i++) {
      d[i] = rand.nextInt(10000);
    }
    list.add(d);
    int[] e = new int[0];
    list.add(e);
    return list;
  }

  private static void printList(ArrayList<int[]> list) {
    for (int[] array : list) {
      for (int x : array) {
        System.out.println(x);
      }
    }
  }
}
