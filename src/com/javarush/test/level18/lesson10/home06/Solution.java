package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

class Solution {

  public static void main(String[] args) throws IOException {

    FileInputStream fileInputStream = new FileInputStream(args[0]);

    byte[] buffer = new byte[fileInputStream.available()];
    //noinspection ResultOfMethodCallIgnored
    fileInputStream.read(buffer);
    fileInputStream.close();
    Map<Byte, Integer> map = new TreeMap<>();

    for (byte aBuffer : buffer) {
      map.put(aBuffer, 1);
    }

    int count = 0;
    for (byte aBuffer : buffer) {
      for (byte aBuffer1 : buffer) {
        if (aBuffer1 == aBuffer) {
          count++;
        }
      }
      map.put(aBuffer, count);
      count = 0;
    }

    for (Map.Entry<Byte, Integer> pair : map.entrySet()) {
      System.out.println(pair.getKey() + " " + pair.getValue());
    }
  }
}
