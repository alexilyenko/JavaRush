package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class Solution {

  private static final TestString testString = new TestString();

  public static void main(String[] args) {
    PrintStream defaultPrintStream = System.out;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(byteArrayOutputStream));
    testString.printSomething();
    System.setOut(defaultPrintStream);

    String[] byteArray = byteArrayOutputStream.toString().split("\\n");
    for (int i = 0; i < byteArray.length; i++) {
      System.out.println(byteArray[i]);
      if (i % 2 != 0) {
        System.out.println("JavaRush - курсы Java онлайн");
      }
    }
  }

  static class TestString {

    void printSomething() {
      System.out.println("first");
      System.out.println("second");
      System.out.println("third");
      System.out.println("fourth");
      System.out.println("fifth");
    }
  }
}
