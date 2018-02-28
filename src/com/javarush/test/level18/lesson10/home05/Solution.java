package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution {

  public static void main(String[] args) throws IOException {
    ArrayList<Integer> numbers = new ArrayList<>();

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String fileName1 = reader.readLine();
    String fileName2 = reader.readLine();
    reader.close();

    BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
    String str;
    String[] strMass;
    double tmp;

    while ((str = fileReader.readLine()) != null) {
      strMass = str.split(" ");
      for (String strMas : strMass) {
        tmp = Math.round(Double.parseDouble(strMas));
        numbers.add((int) tmp);
      }
    }
    fileReader.close();

    BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));
    StringBuilder num = new StringBuilder();
    for (int a : numbers) {
      num.append(a).append(" ");
    }
    fileWriter.write(num.toString());
    fileWriter.close();
  }
}
