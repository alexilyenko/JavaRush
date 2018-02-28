package com.javarush.test.level20.lesson02.task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
class Solution {

  public static void main(String[] args) {
    try {

      File fileName = File.createTempFile("d:\\1.txt", null);
      OutputStream outputStream = new FileOutputStream(fileName);
      InputStream inputStream = new FileInputStream(fileName);

      Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
      ivanov.save(outputStream);
      outputStream.flush();

      Human somePerson = new Human();
      somePerson.load(inputStream);

      System.out.println(ivanov);
      System.out.println(somePerson);
      inputStream.close();

    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Oops, something wrong with my file");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Oops, something wrong with save/load method");
    }
  }


  static class Human {

    final List<Asset> assets = new ArrayList<>();
    String name;

    Human() {
    }

    Human(String name, Asset... assets) {
      this.name = name;
      if (assets != null) {
        this.assets.addAll(Arrays.asList(assets));
      }
    }

    void save(OutputStream outputStream) {
      PrintWriter printWriter = new PrintWriter(outputStream);
      String hasName = (this.name != null) ? "yes" : "no";
      printWriter.println(hasName);
      if ("yes".equals(hasName)) {
        printWriter.println(this.name);
        if (this.assets.size() > 0) {
          for (Asset current : this.assets) {
            printWriter.println(current.getName());
          }
        }
      }
      printWriter.close();
    }

    void load(InputStream inputStream) throws Exception {
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      String hasName = reader.readLine();
      if ("yes".equals(hasName)) {
        this.name = reader.readLine();
        String assetName;
        while ((assetName = reader.readLine()) != null) {
          this.assets.add(new Asset(assetName));
        }
      }
      reader.close();
    }
  }
}
