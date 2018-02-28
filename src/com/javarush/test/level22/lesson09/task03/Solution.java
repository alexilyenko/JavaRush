package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена

*/

class Solution {

  public static void main(String[] args) throws IOException {
    //...
    Scanner scanner = new Scanner(System.in);
    String fileName = scanner.nextLine();
    ArrayList<String> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    while (reader.ready()) {
      String[] s = reader.readLine().split("\\s");
      Collections.addAll(list, s);
    }
    reader.close();
    String[] words = new String[list.size()];
    words = list.toArray(words);
    StringBuilder result = getLine(words);
    System.out.println(result.toString());
    scanner.close();
  }

  private static StringBuilder getLine(String... words) {
    ArrayList<String> strings = new ArrayList<>();
    Collections.addAll(strings, words);
    StringBuilder sb = new StringBuilder();
    if (strings.size() == 0) {
      return new StringBuilder();
    }

    sb.append(strings.get(0));
    strings.remove(0);

    while (strings.size() > 0) {
      for (int i = 0; i < strings.size(); i++) {
        String a = strings.get(i).toUpperCase().toLowerCase();
        String b = sb.toString().toUpperCase().toLowerCase();
        if (a.charAt(0) == b.charAt(sb.length() - 1)) { // в конец
          sb.append(" ").append(strings.get(i));
          strings.remove(i);
          continue;
        }

        if (b.charAt(0) == a.charAt(a.length() - 1)) { //в начало
          sb.insert(0, " ");
          sb.insert(0, strings.get(i));
          strings.remove(i);
        }
      }
    }
    return sb;
  }
}
