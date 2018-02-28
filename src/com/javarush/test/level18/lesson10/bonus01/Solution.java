package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@SuppressWarnings("Duplicates")
class Solution {

  public static void main(String[] args) throws IOException {
    String fileName = args[1];
    FileInputStream fileInputStream = new FileInputStream(fileName);
    byte[] buffer = new byte[fileInputStream.available()];
    //noinspection ResultOfMethodCallIgnored
    fileInputStream.read(buffer);
    fileInputStream.close();

    byte[] result = new byte[0];

    if (args[0].equals("-e")) {
      result = encode(buffer);
    } else if (args[0].equals("-d")) {
      result = decode(buffer);
    }

    String fileOutputName = args[2];
    FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);
    fileOutputStream.write(result);
    fileOutputStream.close();
  }

  private static byte[] encode(byte[] content) {
    String pKey = "myKey";
    byte[] key = pKey.getBytes();
    byte[] res = new byte[content.length];

    for (int i = 0; i < content.length; i++) {
      res[i] = (byte) (content[i] ^ key[i % key.length]);
    }

    return res;
  }

  private static byte[] decode(byte[] content) {
    String pKey = "myKey";
    byte[] key = pKey.getBytes();
    byte[] res = new byte[content.length];

    for (int i = 0; i < content.length; i++) {
      res[i] = (byte) (content[i] ^ key[i % key.length]);
    }

    return res;
  }

}
