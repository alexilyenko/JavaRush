package com.javarush.test.level20.lesson07.task05;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.
Hint/Подсказка:
Конструктор не вызывается при сериализации, только инициализируются все поля.
*/
class Solution implements Serializable, Runnable {

  @SuppressWarnings("FieldCanBeLocal")
  private final int speed;
  transient private Thread runner;

  public Solution(int speed) {
    this.speed = speed;
    runner = new Thread(this);
    runner.start();
  }

  public void run() {
  }

  private void writeObject(ObjectOutputStream out) throws IOException {
    out.defaultWriteObject();
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    runner = new Thread(this);
    runner.start();
  }
}
