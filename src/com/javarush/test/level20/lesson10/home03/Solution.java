package com.javarush.test.level20.lesson10.home03;

import java.io.Serializable;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите и исправьте ошибку.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
*/
class Solution implements Serializable {

  static class A {

    String name = "A";

    A() {
    }

    A(String name) {
      this.name += name;
    }
  }

  private class B extends A implements Serializable {

    public B(String name) {
      super(name);
      this.name += name;
    }
  }
}
