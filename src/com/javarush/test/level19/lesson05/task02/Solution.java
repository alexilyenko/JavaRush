package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String fileName = bufferedReader.readLine();
    bufferedReader.close();
    BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
    ArrayList<String> list = new ArrayList<>();
    String nextLine;
    while ((nextLine = fileReader.readLine()) != null) {
      list.add(nextLine);
    }
    fileReader.close();
    String[] wordArray;
    int count = 0;
    for (String aString : list) {
      wordArray = aString.split(" ");
      for (int i = 0; i < wordArray.length; i++) {
        wordArray[i] = wordArray[i].replaceAll("[^A-Za-z0-9]", "");
        if (wordArray[i].equals("world")) {
          count++;
        }
      }
    }
    System.out.println(count);
  }
}
