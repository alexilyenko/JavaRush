package com.javarush.test.level23.lesson06.task01;

/* Как выбрать нужное?
В методе main присвойте объекту Object obj экземпляр класса TEST
Константу TEST и класс TEST менять нельзя.
*/
class Solution {

  public static final String TEST = "test";
  @SuppressWarnings("FieldCanBeLocal")
  private static Object obj;

  public static void main(String[] args) {
    obj = new TEST();
    System.out.println(obj);
  }

  static class TEST {

    @Override
    public String toString() {
      return "test class";
    }
  }
}
