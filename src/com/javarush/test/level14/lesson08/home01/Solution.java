package com.javarush.test.level14.lesson08.home01;

/* Мосты
1. Создать интерфейс Bridge с методом int getCarsCount().
2. Создать классы WaterBridge и SuspensionBridge, которые реализуют интерфейс Bridge.
3. Метод getCarsCount() должен возвращать любое значение типа int.
4. Метод getCarsCount должен возвращать различные значения для различных классов.
5. В классе Solution создать публичный метод println(Bridge bridge).
6. В методе println вывести на консоль значение getCarsCount() для объекта bridge.
7. Каждый класс и интерфейс должны быть в отдельных файлах.
*/


class Solution {

  public static void main(String[] args) {
    println(new WaterBridge());
    println(new SuspensionBridge());
  }

  private static void println(Bridge bridge) {
    System.out.println(bridge.getCarsCount());
  }
}

