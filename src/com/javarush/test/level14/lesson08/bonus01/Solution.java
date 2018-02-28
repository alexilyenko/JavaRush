package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.invoke.WrongMethodTypeException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

class Solution {

  private static final List<Exception> exceptions = new ArrayList<>();

  public static void main(String[] args) {
    initExceptions();

    for (Exception exception : exceptions) {
      System.out.println(exception.getMessage());
    }
  }

  @SuppressWarnings("NumericOverflow")
  private static void initExceptions() {   //it's first exception
    try {
      float i = 1 / 0;
    } catch (Exception e) {
      exceptions.add(e);
    }
    try {
      int a = 1 / 0;
    } catch (ArithmeticException e) {
      exceptions.add(new Exception());
    }
    exceptions.add(new ArrayIndexOutOfBoundsException());
    exceptions.add(new ClassCastException());
    exceptions.add(new ClassNotFoundException());
    exceptions.add(new RuntimeException());
    exceptions.add(new IOException());
    exceptions.add(new FileNotFoundException());
    exceptions.add(new NoSuchElementException());
    exceptions.add(new WrongMethodTypeException());
  }
}
