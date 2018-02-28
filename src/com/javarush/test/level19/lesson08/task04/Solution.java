package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
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

    String result = byteArrayOutputStream.toString();
    String[] resultArray = result.split(" ");
    int firstNum = Integer.parseInt(resultArray[0]);
    int secondNum = Integer.parseInt(resultArray[2]);
    int arithmeticResult;

    switch (resultArray[1]) {
      case "+":
        arithmeticResult = firstNum + secondNum;
        break;
      case "-":
        arithmeticResult = firstNum - secondNum;
        break;
      default:
        arithmeticResult = firstNum * secondNum;
        break;
    }

    System.out
        .println(firstNum + " " + resultArray[1] + " " + secondNum + " = " + arithmeticResult);
  }

  static class TestString {

    void printSomething() {
      System.out.println("3 + 6 = ");
    }
  }
}

