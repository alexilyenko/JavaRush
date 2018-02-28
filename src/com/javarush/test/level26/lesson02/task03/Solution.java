package com.javarush.test.level26.lesson02.task03;

import java.util.Comparator;

/* Убежденному убеждать других не трудно.
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напишите public static компаратор CustomizedComparator, который будет:
1. в конструкторе принимать список компараторов
2. сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т
В конструктор передается как минимум один компаратор
*/
class Solution {

  static class CustomizedComparator<T> implements Comparator<T> {

    private final Comparator<T>[] comparators;

    @SafeVarargs
    public CustomizedComparator(Comparator<T>... comparators) {
      this.comparators = comparators;
    }

    @Override
    public int compare(T o1, T o2) {
      int difference = 0;
      for (Comparator<T> comparator : comparators) {
        difference = comparator.compare(o1, o2);
        if (difference != 0) {
          break;
        }
      }
      return difference;
    }
  }
}
