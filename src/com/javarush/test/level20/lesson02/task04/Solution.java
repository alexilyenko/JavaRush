package com.javarush.test.level20.lesson02.task04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

/* Читаем и пишем в файл статики
Реализуйте логику записи в файл и чтения из файла для класса ClassWithStatic
Метод load должен инициализировать объект включая статические поля данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
class Solution {

  public static void main(String[] args) {
    try {

      File fileName = File.createTempFile("d:/1.txt", null);
      OutputStream outputStream = new FileOutputStream(fileName);
      InputStream inputStream = new FileInputStream(fileName);

      ClassWithStatic classWithStatic = new ClassWithStatic();
      classWithStatic.i = 3;
      classWithStatic.j = 4;
      classWithStatic.save(outputStream);
      outputStream.flush();

      ClassWithStatic loadedObject = new ClassWithStatic();
      ClassWithStatic.staticString = "something";
      loadedObject.i = 6;
      loadedObject.j = 7;

      loadedObject.load(inputStream);
      System.out.println(ClassWithStatic.staticString);

      outputStream.close();
      inputStream.close();

    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Oops, something wrong with my file");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Oops, something wrong with save/load method");
    }
  }

  static class ClassWithStatic {

    static String staticString = "it's test static string";
    int i;
    int j;

    void save(OutputStream outputStream) {
      PrintWriter printWriter = new PrintWriter(outputStream);
      String hasStaticString = (staticString != null) ? "yes" : "no";
      printWriter.println(hasStaticString);
      if ("yes".equals(hasStaticString)) {
        printWriter.println(staticString);
      }
      printWriter.println(this.i);
      printWriter.println(this.j);
      printWriter.close();
    }

    void load(InputStream inputStream) throws Exception {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      String hasStaticString = bufferedReader.readLine();
      if ("yes".equals(hasStaticString)) {
        staticString = bufferedReader.readLine();
      }
      this.i = Integer.parseInt(bufferedReader.readLine());
      this.j = Integer.parseInt(bufferedReader.readLine());
      bufferedReader.close();
    }
  }
}
