package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String fileName = reader.readLine();
    FileInputStream inputStream = new FileInputStream(fileName);
    byte[] buffer = new byte[inputStream.available()];
    if (inputStream.available() > 0) {
      int count = inputStream.read(buffer);
    }

    int coma = 0;
    for (byte aBuffer : buffer) {
      if (aBuffer == 44) {
        coma++;
      }
    }

    System.out.println(coma);

    reader.close();
    inputStream.close();


  }
}
