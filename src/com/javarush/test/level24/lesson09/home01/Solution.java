package com.javarush.test.level24.lesson09.home01;

import java.util.LinkedList;
import java.util.List;

/* Рефакторинг
Сделайте так, чтобы метод getIterator возвращал анонимный класс.
Перенесите логику LocalIterator в анонимный класс.
Меняйте только тело метода getIterator.
*/
class Solution {

  @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
  private static final List<Iterator> iterators = new LinkedList<>();

  private int countItems;

  public static void main(String[] args) {
    Solution solution = new Solution();

    Iterator iterator = solution.getIterator("iterator");
    for (int i = 1; i < 5; i++) {
      iterators.add(iterator.next());
    }
  }

  private Iterator getIterator(final String name) {
    return new Iterator() {
      String iteratorName;

      {
        iteratorName = name;
        countItems++;
        System.out.println(iteratorName + " item " + countItems);
      }

      public Iterator next() {
        return getIterator(name);
      }
    };
  }
}
