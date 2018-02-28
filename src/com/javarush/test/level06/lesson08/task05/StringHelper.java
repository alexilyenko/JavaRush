package com.javarush.test.level06.lesson08.task05;

/* Класс StringHelper
Cделать класс StringHelper, у которого будут 2 статических метода:
String multiply(String s, int count) – возвращает строку повторенную count раз.
String multiply(String s) – возвращает строку повторенную 5 раз.
Пример:
Амиго -> АмигоАмигоАмигоАмигоАмиго
*/

class StringHelper {

  public static String multiply(String s) {
    StringBuilder result = new StringBuilder();
    for (int x = 0; x < 5; x++) {
      result.append(s);
    }
    return result.toString();
  }

  public static String multiply(String s, int count) {
    StringBuilder result = new StringBuilder();
    for (int x = 0; x < count; x++) {
      result.append(s);
    }
    return result.toString();
  }
}
