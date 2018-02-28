package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую половину.
Закрыть потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

class Solution {

  public static void main(String[] args) throws Exception {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String fileName1 = bufferedReader.readLine();
    String fileName2 = bufferedReader.readLine();
    String fileName3 = bufferedReader.readLine();

    FileInputStream fileInputStream = new FileInputStream(fileName1);
    FileOutputStream fileOutputStream2 = new FileOutputStream(fileName2);
    FileOutputStream fileOutputStream3 = new FileOutputStream(fileName3);

    byte[] buffer = new byte[fileInputStream.available()];
    if (fileInputStream.available() > 0) {
      //noinspection ResultOfMethodCallIgnored
      fileInputStream.read(buffer);
    }

    byte[] buffer2;
    byte[] buffer3 = new byte[buffer.length / 2];

    if (buffer.length % 2 == 0) {
      buffer2 = new byte[buffer.length / 2];
      System.arraycopy(buffer, 0, buffer2, 0, buffer2.length);
      System.arraycopy(buffer, buffer.length / 2, buffer3, 0, buffer.length / 2);
    } else {
      buffer2 = new byte[buffer.length / 2 + 1];
      System.arraycopy(buffer, 0, buffer2, 0, buffer2.length);
      for (int i = buffer.length / 2 + 1; i < buffer.length; i++) {
        buffer3[i - buffer.length / 2 - 1] = buffer[i];
      }
    }
    fileOutputStream2.write(buffer2);
    fileOutputStream3.write(buffer3);

    bufferedReader.close();
    fileInputStream.close();
    fileOutputStream2.close();
    fileOutputStream3.close();
  }
}
