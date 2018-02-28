package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String fileName1 = bufferedReader.readLine();
    String fileName2 = bufferedReader.readLine();
    bufferedReader.close();

    ArrayList<Integer> list = new ArrayList<>();
    FileReader fileReader = new FileReader(fileName1);
    while (fileReader.ready()) {
      list.add(fileReader.read());
    }
    fileReader.close();

    FileWriter fileWriter = new FileWriter(fileName2);
    for (int i = 1; i < list.size(); i = i + 2) {
      fileWriter.write((char) (int) list.get(i));
    }
    fileWriter.close();
  }
}
