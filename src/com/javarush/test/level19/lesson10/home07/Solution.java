package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class Solution {

  public static void main(String[] args) throws IOException {
    String fileName1 = args[0];
    String input;
    ArrayList<String> fileList = new ArrayList<>();
    BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
    while ((input = fileReader.readLine()) != null) {
      fileList.add(input);
    }
    fileReader.close();

    ArrayList<String> resultWords = new ArrayList<>();
    for (String aFileList : fileList) {
      String[] stringArray = aFileList.split(" ");
      for (String aStringArray : stringArray) {
        if (aStringArray.length() > 6) {
          resultWords.add(aStringArray);
        }
      }
    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < resultWords.size(); i++) {
      if (i == resultWords.size() - 1) {
        result.append(resultWords.get(i));
      } else {
        result.append(resultWords.get(i)).append(",");
      }
    }

    String fileName2 = args[1];
    PrintWriter printWriter = new PrintWriter(new FileWriter(fileName2));
    printWriter.println(result);
    printWriter.close();
  }
}
