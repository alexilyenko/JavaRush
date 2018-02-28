package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл.
*/

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
    String fileName = consoleReader.readLine();
    List<String> stringList = new ArrayList<>();
    FileWriter outStream = new FileWriter(fileName);
    while (true) {
      String s = consoleReader.readLine();
      if (s.equalsIgnoreCase("exit")) {
        stringList.add(s);
        for (String aStringList : stringList) {
          outStream.write(aStringList + "\n");
        }
        break;
      }
      stringList.add(s);
    }
    outStream.close();
  }
}
