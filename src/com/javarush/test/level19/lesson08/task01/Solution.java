package com.javarush.test.level19.lesson08.task01;

/* Ридер обертка
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна преобразовывать весь текст в заглавные буквы
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class Solution {

  private static final TestString testString = new TestString();

  public static void main(String[] args) {
    PrintStream defaultPrintStream = System.out;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream newPrintStream = new PrintStream(byteArrayOutputStream);
    System.setOut(newPrintStream);
    testString.printSomething();
    System.setOut(defaultPrintStream);

    String result = byteArrayOutputStream.toString().toUpperCase();
    System.out.println(result);
  }

  static class TestString {

    void printSomething() {
      System.out.println("it's a text for testing");
    }
  }
}
