package com.javarush.test.level18.lesson05.task01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* Исправить ошибки
Исправить функциональность в соответствии с требованиями
Программа должна:
1. переписать все байты одного файла в другой одним куском.
2. закрывать потоки ввода-вывода
Подсказка: 4 ошибки
*/

class Solution {

  public static void main(String[] args) throws IOException {
    FileInputStream inputStream = new FileInputStream("c:/data.txt");
    // Создаем поток-записи-байт-в-файл
    FileOutputStream outputStream = new FileOutputStream("c:/result.txt");

    byte[] buffer = new byte[inputStream.available()];
    if (inputStream.available() > 0) {
      //читаем весь файл одним куском
      int count = inputStream.read(buffer);
      outputStream.write(buffer, 0, count);
    }

    inputStream.close();
    outputStream.close();
  }
}
