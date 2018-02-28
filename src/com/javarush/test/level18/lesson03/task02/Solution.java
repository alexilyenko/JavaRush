package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

class Solution {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String fileName = reader.readLine();
    reader.close();
    FileInputStream input = new FileInputStream(fileName);
    int min = input.read();
    while (input.available() > 0) {
      int data = input.read();
      if (data < min) {
        min = data;
      }
    }
    input.close();
    System.out.println(min);
  }
}
