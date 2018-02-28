package com.javarush.test.level20.lesson10.home04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* Исправить ошибку
После десериализации объекта класса Solution обнаружили, что данных в словаре [m] нет :(
Исправить 1 ошибку.
Метод main в тестировании не участвует.
*/
class Solution implements Serializable {

  private final Map<String, String> m = new HashMap<>();

  @SuppressWarnings("OverwrittenKey")
  private Solution() {
    m.put("Mickey", "Mouse");
    m.put("Mickey", "Mantle");
  }

  public static void main(String args[]) throws Exception {
    FileOutputStream fileOutput = new FileOutputStream("d:/1.txt");
    ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

    Solution solution = new Solution();
    outputStream.writeObject(solution);

    fileOutput.close();
    outputStream.close();

    FileInputStream fiStream = new FileInputStream("d:/1.txt");
    ObjectInputStream objectStream = new ObjectInputStream(fiStream);

    Solution loadedObject = (Solution) objectStream.readObject();

    fiStream.close();
    objectStream.close();

    System.out.println(loadedObject.getMap().toString());
  }

  private Map<String, String> getMap() {
    return m;
  }

  public int size() {
    return m.size();
  }
}
