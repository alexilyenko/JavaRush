package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
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

    String fileName2 = args[1];
    PrintWriter printWriter = new PrintWriter(new FileWriter(fileName2, true));
    for (String aFileList : fileList) {
      String[] stringArray = aFileList.split(" ");
      StringBuilder fileString = new StringBuilder();
      for (String aStringArray : stringArray) {
        if (aStringArray.matches(".*\\d.*")) {
          fileString.append(aStringArray).append(" ");
        }
      }
      printWriter.println(fileString);
    }
    printWriter.close();
  }
}
