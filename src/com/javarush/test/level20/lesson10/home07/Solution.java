package com.javarush.test.level20.lesson10.home07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
*/
class Solution implements Serializable, AutoCloseable {

  private final String fileName;
  private transient FileOutputStream stream;

  @SuppressWarnings("SameParameterValue")
  private Solution(String fileName) throws FileNotFoundException {
    this.fileName = fileName;
    this.stream = new FileOutputStream(fileName);
  }

  public static void main(String[] args) throws Exception {
    Solution solution1 = new Solution("D:\\1.txt");
    solution1.writeObject("Hi1");
    solution1.close();
    //SAVE
    FileOutputStream fileOutputStream = new FileOutputStream("D:\\2.txt");
    ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
    outputStream.writeObject(solution1);
    outputStream.flush();
    outputStream.close();
    //LOAD
    FileInputStream fileInputStream = new FileInputStream("D:\\2.txt");
    ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
    Solution solution2 = (Solution) inputStream.readObject();
    inputStream.close();
    solution2.writeObject("Hi2");
    solution2.writeObject("Hi3");
    solution2.close();
  }

  private void writeObject(String string) throws IOException {
    stream.write(string.getBytes());
    stream.write("\n".getBytes());
    stream.flush();
  }

  private void writeObject(ObjectOutputStream out) throws Exception {
    out.defaultWriteObject();
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    stream = new FileOutputStream(this.fileName, true);
  }

  @Override
  public void close() throws Exception {
    System.out.println("Closing everything!");
    stream.close();
  }


}
