package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
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
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String fileName1 = bufferedReader.readLine();
    String fileName2 = bufferedReader.readLine();
    bufferedReader.close();

    BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
    ArrayList<String> list = new ArrayList<>();
    String nextLine;
    while ((nextLine = fileReader.readLine()) != null) {
      list.add(nextLine);
    }
    fileReader.close();

    String[] wordArray;
    ArrayList<Integer> numbers = new ArrayList<>();
    for (String aString : list) {
      wordArray = aString.split(" ");
      for (String aWordArray : wordArray) {
        try {
          numbers.add(Integer.parseInt(aWordArray));
        } catch (NumberFormatException ignored) {
        }
      }
    }

    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));
    for (Integer number : numbers) {
      bufferedWriter.write(number + " ");
    }
    bufferedWriter.close();
  }
}
