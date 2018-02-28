package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> list = new ArrayList<>();
    while (true) {
      String input = reader.readLine();
      if (input.equals("exit")) {
        break;
      }
      list.add(input);
    }

    for (String value : list) {
      if (value.contains(".")) {
        try {
          Double dValue = Double.parseDouble(value);
          print(dValue);
        } catch (NumberFormatException e) {
          print(value);
        }
      } else {
        try {
          Integer iValue = Integer.parseInt(value);
          if (iValue > 0 && iValue < 128) {
            int iiValue = iValue;
            short sValue = (short) iiValue;
            print(sValue);
          } else if (iValue >= 128) {
            print(iValue);
          } else {
            print(value);
          }
        } catch (NumberFormatException e) {
          print(value);
        }

      }
    }
  }

  private static void print(Double value) {
    System.out.println("Это тип Double, значение " + value);
  }

  private static void print(String value) {
    System.out.println("Это тип String, значение " + value);
  }

  private static void print(short value) {
    System.out.println("Это тип short, значение " + value);
  }

  private static void print(Integer value) {
    System.out.println("Это тип Integer, значение " + value);
  }
}
