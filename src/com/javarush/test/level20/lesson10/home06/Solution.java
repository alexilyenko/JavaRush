package com.javarush.test.level20.lesson10.home06;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
class Solution implements Serializable {

  private static class SubSolution extends Solution {

    private void writeObject(ObjectOutputStream out) throws IOException {
      throw new NotSerializableException();
    }
  }
}
