package com.javarush.test.level09.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два имени файла. И копирует первый файл на место, заданное вторым именем.
Новая задача: Программа вводит два имени файла. И копирует первый файл на место, заданное вторым именем.
Если файла (который нужно копировать) с указанным именем не существует, то
программа должна вывести надпись «Файл не существует.» и еще раз прочитать имя файла с консоли, а уже потом считывать файл для записи.
*/

class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String sourceFileName;
    FileInputStream fileInputStream;
    while (true) {
      try {
        sourceFileName = reader.readLine();
        fileInputStream = new FileInputStream(sourceFileName);
        break;
      } catch (FileNotFoundException e) {
        System.out.println("Файл не существует.");
      }
    }
    String destinationFileName = reader.readLine();
    FileOutputStream fileOutputStream = new FileOutputStream(destinationFileName);

    while (fileInputStream.available() > 0) {
      int data = fileInputStream.read();
      fileOutputStream.write(data);
    }

    fileInputStream.close();
    fileOutputStream.close();
  }
}
