package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

class Solution {

  @SuppressWarnings("ResultOfMethodCallIgnored")
  public static void main(String[] args) throws Exception {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String fileName1 = reader.readLine();
    String fileName2 = reader.readLine();
    String fileName3 = reader.readLine();
    reader.close();

    FileOutputStream fileOutputStream1 = new FileOutputStream(fileName1, true);
    FileInputStream fileInputStream2 = new FileInputStream(fileName2);
    FileInputStream fileInputStream3 = new FileInputStream(fileName3);

    byte[] buffer2 = new byte[fileInputStream2.available()];
    fileInputStream2.read(buffer2);
    fileInputStream2.close();

    byte[] buffer3 = new byte[fileInputStream3.available()];
    fileInputStream3.read(buffer3);
    fileInputStream3.close();

    fileOutputStream1.write(buffer2);
    fileOutputStream1.write(buffer3);
    fileOutputStream1.close();

  }
}
