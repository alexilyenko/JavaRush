package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение, вывести в консоль переданное неправильное имя файла и завершить работу программы
Не забудьте закрыть все потоки
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

  public static void main(String[] args) {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    FileInputStream fileInputStream = null;
    String fileName = null;
    while (true) {
      try {
        fileName = bufferedReader.readLine();
        fileInputStream = new FileInputStream(fileName);
        //noinspection ResultOfMethodCallIgnored
        fileInputStream.read();
      } catch (FileNotFoundException e) {
        System.out.println(fileName);
        break;
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          assert fileInputStream != null;
          fileInputStream.close();
        } catch (Exception ignore) {/*NOP*/}
      }
    }
  }
}
