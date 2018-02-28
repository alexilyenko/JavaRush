package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
class Solution {

  private final String first, last;

  private Solution(String first, String last) {
    this.first = first;
    this.last = last;
  }

  public static void main(String[] args) {
    Set<Solution> s = new HashSet<>();
    s.add(new Solution("Mickey", "Mouse"));
    System.out.println(s.contains(new Solution("Mickey", "Mouse")));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Solution solution = (Solution) o;

    return (first != null ? first.equals(solution.first) : solution.first == null) && (last != null
        ? last.equals(solution.last) : solution.last == null);
  }

  @Override
  public int hashCode() {
    int result = first != null ? first.hashCode() : 0;
    result = 31 * result + (last != null ? last.hashCode() : 0);
    return result;
  }
}
