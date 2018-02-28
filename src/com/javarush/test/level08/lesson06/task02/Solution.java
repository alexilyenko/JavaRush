package com.javarush.test.level08.lesson06.task02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Провести 10 тысяч вставок, удалений
Для arrayList и linkedList провести 10 тысяч вставок, удалений, а также вызовов get и set.
*/

class Solution {

  public static void main(String[] args) {
    // ArrayList
    ArrayList<Integer> arrayList = new ArrayList<>();
    insert10000(arrayList);
    get10000(arrayList);
    set10000(arrayList);
    remove10000(arrayList);

    // LinkedList
    LinkedList<Integer> linkedList = new LinkedList<>();
    insert10000(linkedList);
    get10000(linkedList);
    set10000(linkedList);
    remove10000(linkedList);
  }

  private static void insert10000(List<Integer> list) {
    for (int i = 0; i < 10000; i++) {
      list.add(i);
    }
  }

  private static void get10000(List<Integer> list) {
    for (int i = 0; i < 10000; i++) {
      //noinspection ResultOfMethodCallIgnored
      list.get(i);
    }

  }

  private static void set10000(List<Integer> list) {
    for (int i = 0; i < 10000; i++) {
      list.set(i, i);
    }
  }

  private static void remove10000(List<Integer> list) {
    for (int i = 0; i < 10000; i++) {
      list.remove(0);
    }
  }
}
