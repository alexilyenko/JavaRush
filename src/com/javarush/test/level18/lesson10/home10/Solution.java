package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Solution {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> list = new ArrayList<>();
    String fileName;

    while (!(fileName = bufferedReader.readLine()).equals("end")) {
      list.add(fileName);
    }

    bufferedReader.close();
    Collections.sort(list);

    String[] stringArray = list.get(0).split(".part");
    String summaryFileName = stringArray[0];

    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream = new FileOutputStream(summaryFileName, true);
    byte[] buffer;

    for (String aList : list) {
      fileInputStream = new FileInputStream(aList);
      buffer = new byte[fileInputStream.available()];
      //noinspection ResultOfMethodCallIgnored
      fileInputStream.read(buffer);
      fileInputStream.close();
      fileOutputStream.write(buffer);
    }

    fileOutputStream.close();
  }
}
