package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
class Solution {

  @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
  private static final List<Pair> result = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    List<String> words = new ArrayList<>();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
    bufferedReader.close();
    while (fileReader.ready()) {
      words.addAll(Arrays.asList(fileReader.readLine().split(" ")));
    }
    fileReader.close();

    for (int i = 0; i < words.size(); i++) {
      for (int j = 0; j < words.size(); ) {
        if (words.get(j).equals(new StringBuilder(words.get(i)).reverse().toString()) && j != i) {
          Pair pair = new Pair();
          pair.first = words.get(j);
          pair.second = words.get(i);
          result.add(pair);
          words.remove(j);
          words.remove(i);
          j = 0;
        } else {
          j++;
        }
      }
    }

  }

  static class Pair {

    String first;
    String second;

    @SuppressWarnings("ConstantConditions")
    @Override
    public String toString() {
      return first == null && second == null ? "" :
          first == null && second != null ? second :
              second == null && first != null ? first :
                  first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
    }
  }

}
