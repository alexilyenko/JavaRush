package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String fileName = bufferedReader.readLine();
    String insideFile;
    StringBuilder sumString = new StringBuilder();

    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(fileName));
    while ((insideFile = bufferedReader2.readLine()) != null) {
      sumString.append(insideFile).append(" ");
    }

    String[] strArray = sumString.toString().split(" ");
    double parsing;
    int startI = 0;
    int endI;

    for (int i = 0; i < strArray.length; i++) {
      if (strArray[i].equals(args[0])) {
        startI = i;
        break;
      }
    }

    int trueStart = startI;
    while (true) {
      try {
        //noinspection ResultOfMethodCallIgnored
        Double.parseDouble(strArray[startI + 1]);
        endI = startI + 2;
        break;
      } catch (Exception e) {
        startI++;
      }
    }

    for (int i = trueStart; i <= endI; i++) {
      System.out.print(strArray[i] + " ");
    }
  }
}
