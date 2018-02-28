package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

class Solution {

  private static final List<String> words = new ArrayList<>();

  static {
    words.add("файл");
    words.add("вид");
    words.add("В");
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String fileName = bufferedReader.readLine();
    ArrayList<String> fileList = new ArrayList<>();
    String input;
    BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
    while ((input = fileReader.readLine()) != null) {
      fileList.add(input);
    }
    fileReader.close();

    for (String aFileList : fileList) {
      String[] stringArray = aFileList.split(" ");
      int match = 0;
      for (String aStringArray : stringArray) {
        for (String word : words) {
          if (word.equals(aStringArray)) {
            match++;
          }
        }
      }
      if (match == 2) {
        System.out.println(aFileList);
      }
    }
  }
}
