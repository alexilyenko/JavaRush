package com.javarush.test.level10.lesson04.task01;

/* Задача №1 на преобразование целых типов
Расставь где нужно оператор приведения типа:
byte a = 1234;
int b = a;
byte c = a * a;
int d = a / c;
*/

import java.io.FileWriter;
import java.io.IOException;

class Solution {

  public static void main(String[] args) {
    try {
      FileWriter writer = new FileWriter("d:\\myfile.csv", true);
      writer.append("DisplayName");
      writer.append(';');
      writer.append("Age");
      writer.append('\n');
      writer.append("MKYONG");
      writer.append(';');
      writer.append("26");
      writer.append('\n');
      writer.append("YOUR NAME");
      writer.append(';');
      writer.append("29");
      writer.append('\n');          //generate whatever data you want
      writer.flush();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
