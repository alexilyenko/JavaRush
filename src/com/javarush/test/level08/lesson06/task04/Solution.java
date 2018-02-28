package com.javarush.test.level08.lesson06.task04;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* Измерить сколько времени занимает 10 тысяч вызовов get для каждого списка
Измерить, сколько времени занимает 10 тысяч вызовов get для каждого списка.
Метод getTimeMsOfGet  должен вернуть время его исполнения в миллисекундах.
*/

class Solution {

  public static void main(String[] args) {
    System.out.println(getTimeMsOfGet(fill(new ArrayList<>())));
    System.out.println(getTimeMsOfGet(fill(new LinkedList<>())));
  }

  private static List<Object> fill(List<Object> list) {
    for (int i = 0; i < 11; i++) {
      list.add(new Object());
    }
    return list;
  }

  private static long getTimeMsOfGet(List<Object> list) {
    Date startDate = new Date();
    get10000(list);
    Date endDate = new Date();
    return endDate.getTime() - startDate.getTime();

  }

  private static void get10000(List<Object> list) {
    if (list.isEmpty()) {
      return;
    }
    int x = list.size() / 2;
    for (int i = 0; i < 10000; i++) {
      //noinspection ResultOfMethodCallIgnored
      list.get(x);
    }
  }
}
