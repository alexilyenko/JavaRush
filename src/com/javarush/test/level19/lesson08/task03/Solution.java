package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Пример вывода:
12345678
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

    String result;
    result = byteArrayOutputStream.toString().replaceAll("[^0-9]", "");
    System.out.println(result);
  }

  static class TestString {

    void printSomething() {
      System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
    }
  }
}
