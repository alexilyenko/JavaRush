package com.javarush.test.level21.lesson05.task03;

import java.util.Date;

/* Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution
*/
class Solution {

  private final int anInt;
  private final String string;
  private final double aDouble;
  private final Date date;
  private final Solution solution;

  public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
    this.anInt = anInt;
    this.string = string;
    this.aDouble = aDouble;
    this.date = date;
    this.solution = solution;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Solution)) {
      return false;
    }

    Solution solution1 = (Solution) o;

    return Double.compare(solution1.aDouble, aDouble) == 0 && anInt == solution1.anInt && (
        date != null ? date.equals(solution1.date) : solution1.date == null) && (solution != null
        ? solution.equals(solution1.solution) : solution1.solution == null) && (string != null
        ? string.equals(solution1.string) : solution1.string == null);
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = anInt;
    temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + (solution != null ? solution.hashCode() : 0);
    result = 31 * result + (date != null ? date.hashCode() : 0);
    result = 31 * result + (string != null ? string.hashCode() : 0);
    return result;
  }
}
